package com.kastech.blumen.service.superadmin;

import com.google.common.io.Resources;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    private String configSetting;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(OrganizationService.class);

    @Transactional
    public Organization createOrganization(Organization organization) throws Exception {
        LOG.info("Inside createOrganization, with payload {} ", organization);
        organization = organizationRepository.save(organization);
        try {
            insertSecurityQuestions(organization);
            insertPullDownList(organization);
            insertConfigSetting(organization);
            insertMasterListPrivilleges(organization);
            insertUserPrivileges(organization);
            insertDefaultRoles(organization);
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }

        return organization;

    }

    private void insertSecurityQuestions(final Organization organization) throws IOException {
        LOG.info("Inside insertSecurityQuestions, with organization {} ", organization);
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", organization.getOrgId());
        map.put("orgType", organization.getOrgOrganizationType());
        namedParameterJdbcTemplate.update(readFile(securityQuestionUrl), map);

    }


    private void insertPullDownList(Organization organization) throws IOException {
        LOG.info("Inside insertPullDownList, with parameter {} ", organization);
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", organization.getOrgId());
        namedParameterJdbcTemplate.update(readFile(pullDownListUrl), map);
    }

    private void insertConfigSetting(final Organization organization) throws IOException {
        LOG.info("Inside insertConfigSetting, with organization {} ", organization);
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", organization.getOrgId());
        map.put("orgType", organization.getOrgOrganizationType());
        namedParameterJdbcTemplate.update(readFile(configSetting), map);

    }

    private void insertMasterListPrivilleges(Organization organization) {
        LOG.info("Inside insertMasterListPrivilleges, with parameter {} ", organization);
        /**
         * TODO - Once ROlES is completed this code will be addressed
         */
       /* jdbcTemplate.batchUpdate(masterPrivilegesUrl, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, "" + organization.getOrgId());
                ps.setString(2, organization.getOrgCode());
            }

            @Override
            public int getBatchSize() {
                return 0;
            }
        }); */
    }

    private void insertUserPrivileges(Organization organization) {
        LOG.info("Inside insertUserPrivileges, with parameter {} ", organization);
        /**
         * TODO - Once ROlES is completed this code will be addressed
         */
       /* jdbcTemplate.batchUpdate(userPrivilegesUrl, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, "" + organization.getOrgId());
                ps.setString(2, organization.getOrgCode());
            }

            @Override
            public int getBatchSize() {
                return 0;
            }
        });*/
    }

    private void insertDefaultRoles(Organization organization) {
        LOG.info("Inside insertDefaultRoles, with parameter {} ", organization);
      /*  jdbcTemplate.batchUpdate(securityQuestionUrl, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, "" + organization.getOrgId());
                ps.setString(2, organization.getOrgCode());
            }

            @Override
            public int getBatchSize() {
                return 0;
            }
        }); */
    }

    private String readFile(final String relFilePath) throws IOException {
        final URL url = Resources.getResource(relFilePath);
        return Resources.toString(url, StandardCharsets.UTF_8);
    }
}