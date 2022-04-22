package com.kastech.blumen.service.superadmin;

import com.google.common.io.Resources;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Value("${security.questions}")
    private String securityQuestionUrl;

    @Value("${pulldown.list}")
    private String pullDownListUrl;

    @Value("${master.privileges}")
    private String masterPrivilegesUrl;

    @Value("${user.privileges}")
    private String userPrivilegesUrl;

    @Value("${default.roles}")
    private String defaultRolesUrl;

    @Value("${config.setting}")
    private String configSettingUrl;

    @Value("${org.users}")
    private String orgUsersUrl;

    @Value("${new.org.data.copy}")
    private String newOrgDataCopyUrl;

    @Value("${users.roles}")
    private String usersRolesUrl;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(OrganizationService.class);

    @Transactional
    public Organization createOrganization(Organization organization) throws Exception {
        LOG.info("Inside createOrganization, with payload {} ", organization);
        try {
            organization = organizationRepository.save(organization);
            this.newOrgDataFromMaster(organization);
            return  organization;
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
    }

    public void batchUpdateForOrgAdmin(LoggedUser loggedUser, Organization organization) throws Exception {
        try {
        insertOrganizationUsers(loggedUser,organization);
        insertUserRoles(loggedUser,organization);
        insertConfigSettings(loggedUser,organization);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void insertOrganizationUsers(LoggedUser loggedUser, Organization organization) throws IOException {
        LOG.info("Inside insertOrganizationUsers, with organization {} ", organization);
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", organization.getOrgId());
        map.put("userId", loggedUser.getId());
        namedParameterJdbcTemplate.update(readFile(orgUsersUrl), map);
    }


    private void newOrgDataFromMaster(final Organization organization) throws IOException {
        LOG.info("Inside newOrgDataFromMaster() with organization {} ", organization);
        Map<String, Object> map = new HashMap<>();
        map.put("org_id", organization.getOrgId());
        namedParameterJdbcTemplate.update(readFile(newOrgDataCopyUrl), map);

    }

    private void insertUserRoles(LoggedUser user, Organization organization)throws IOException {
        LOG.info("Inside insertUserRoles() with parameter {}, {} ", organization, user);
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", organization.getOrgId());
        map.put("roleName", user.getRoleName());
        map.put("userId", user.getId());
        namedParameterJdbcTemplate.update(readFile(usersRolesUrl), map);
    }

    private void insertConfigSettings(LoggedUser user, Organization organization)throws IOException {
        LOG.info("Inside insertUserRoles() with parameter {}, {} ", organization, user);
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", organization.getOrgId());
        map.put("userId", user.getId());
        namedParameterJdbcTemplate.update(readFile(configSettingUrl), map);
    }

    private String readFile(final String relFilePath) throws IOException {
        final URL url = Resources.getResource(relFilePath);
        return Resources.toString(url, StandardCharsets.UTF_8);
    }
}
