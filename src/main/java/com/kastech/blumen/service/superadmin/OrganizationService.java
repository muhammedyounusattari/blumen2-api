package com.kastech.blumen.service.superadmin;

import com.google.common.io.Resources;
import com.kastech.blumen.exception.DataModificationException;
import com.kastech.blumen.exception.DataNotFoundException;
import com.kastech.blumen.exception.InputValidationException;
import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.model.SystemPreferences;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.SystemPreferencesRepository;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.repository.student.configurations.OrganizationTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static com.kastech.blumen.constants.ErrorMessageConstants.*;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationTypeRepository organizationTypeRepository;

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

    @Value("${org.users}")
    private String orgUsersUrl;

    @Value("${new.org.data.copy}")
    private String newOrgDataCopyUrl;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private SystemPreferencesRepository systemPreferencesRepository;

    private static final Logger LOG = LoggerFactory.getLogger(OrganizationService.class);

    @Transactional
    public Organization createOrganization(Organization organization) {
        LOG.info("Inside createOrganization, with payload {} ", organization);
        long orgProgTypeId = 0;
        try {
            List<OrganizationType> organizationTypeList = organizationTypeRepository.findByOrgType(organization.getOrgProgramType());
            if(CollectionUtils.isEmpty(organizationTypeList)){
                throw new InputValidationException(PROGRAM_TYPE_NOT_VALID);
            } else {
                orgProgTypeId = organizationTypeList.get(0).getId();
            }

            organization = organizationRepository.save(organization);
            SystemPreferences systemPreferences = new SystemPreferences();
            systemPreferences.setOrgId(organization.getOrgId());
            systemPreferencesRepository.save(systemPreferences);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("createOrganization failed {}", e.getMessage());
            throw new InputValidationException("New Organization Creation Failed");
        }

        LOG.info("Organization is created with Id {} ", organization.getOrgId());
        try {
            LOG.info("Coping master data from Org 0");
            this.newOrgDataFromMaster(organization, orgProgTypeId);
            return  organization;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataModificationException("New Organization master data copy failed");
        }
    }

    public Organization updateOrganization(Organization organization) {
        //only Admin can create users with in organization/// add role to method
        Optional<Organization> organizationDB = organizationRepository.findById(organization.getOrgId());
        Organization existingOrg = null;
        if(organizationDB.isEmpty()) {
            LOG.error("OrgId {} not found in database", organization.getOrgId());
            throw new DataNotFoundException(INVALID_ORGANIZATION_ID);
        } else {
            existingOrg = organizationDB.get();
            if (!existingOrg.getOrgCode().equals(organization.getOrgCode())) {
                LOG.error("Organization Code {} of Org Id {} can't be changed", existingOrg.getOrgCode(), existingOrg.getOrgId());
                throw new DataModificationException(ORG_CODE_CHANGE_NOT_ALLOWED);
            }
        }

        existingOrg.setOrgActive(organization.getOrgActive());
        existingOrg.setDeleted(organization.getDeleted());
        existingOrg.setOrgCity(organization.getOrgCity());
        existingOrg.setMailServer(organization.getMailServer());
        existingOrg.setOrgAddress2(organization.getOrgAddress2());
        existingOrg.setOrgAddress1(organization.getOrgAddress1());
        existingOrg.setOrgBulkTemplate(organization.getOrgBulkTemplate());
        existingOrg.setOrgDescription(organization.getOrgDescription());
        existingOrg.setOrgDaysToExpire(organization.getOrgDaysToExpire());
        existingOrg.setOrgDeviceAuth(organization.getOrgDeviceAuth());
        existingOrg.setOrgDirector(organization.getOrgDirector());
        existingOrg.setOrgFax(organization.getOrgFax());
        existingOrg.setOrgEmail(organization.getOrgEmail());
        existingOrg.setOrgName(organization.getOrgName());
        existingOrg.setOrgZipCode(organization.getOrgZipCode());
        existingOrg.setOrgWebSite(organization.getOrgWebSite());
        existingOrg.setOrgUserName(organization.getOrgUserName());
        existingOrg.setOrgTwoFactor(organization.getOrgTwoFactor());
        existingOrg.setOrgTrioBlumenLab(organization.getOrgTrioBlumenLab());
        existingOrg.setOrgState(organization.getOrgState());
        existingOrg.setOrgSiteLocation(organization.getOrgSiteLocation());
        existingOrg.setOrgSendMail(organization.getOrgSendMail());
        existingOrg.setOrgScript(organization.getOrgScript());
        existingOrg.setOrgRemindTwo(organization.getOrgRemindTwo());
        existingOrg.setOrgRemindOne(organization.getOrgRemindOne());
        existingOrg.setOrgPurge(organization.getOrgPurge());
        existingOrg.setOrgProgramType(organization.getOrgProgramType());
        existingOrg.setOrgPhoneTwo(organization.getOrgPhoneTwo());
        existingOrg.setOrgPhoneOne(organization.getOrgPhoneOne());
        existingOrg.setOrgPhoneThree(organization.getOrgPhoneThree());
        existingOrg.setOrgOrganizationType(organization.getOrgOrganizationType());
        existingOrg.setOrgNotes(organization.getOrgNotes());
        existingOrg.setOrgNavigateToUser(organization.getOrgNavigateToUser());
        existingOrg.setOrgGoodTill(organization.getOrgGoodTill());
        existingOrg.setOrgExpiryTime(organization.getOrgExpiryTime());
        existingOrg.setOrgDaysToExpire(organization.getOrgDaysToExpire());
        //users doesn't set so we don't delete users from org users table b

        try {
            organization = organizationRepository.save(existingOrg);
        } catch (Exception e) {
            throw new DataModificationException(ORG_UPDATE_FAILED);
        }
        return organization;
    }

    public void batchUpdateForOrgAdmin(LoggedUser loggedUser, Organization organization) throws Exception {
        try {
        insertOrganizationUsers(loggedUser,organization);
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


    private void newOrgDataFromMaster(final Organization organization, final long orgProgTypeId) throws IOException {
        LOG.info("Inside newOrgDataFromMaster() with organization {} ", organization);
        Map<String, Object> map = new HashMap<>();
        map.put("org_id", organization.getOrgId());
        map.put("proj_type", orgProgTypeId); //project type id
        namedParameterJdbcTemplate.update(readFile(newOrgDataCopyUrl), map);

    }

    private String readFile(final String relFilePath) throws IOException {
        final URL url = Resources.getResource(relFilePath);
        return Resources.toString(url, StandardCharsets.UTF_8);
    }
}
