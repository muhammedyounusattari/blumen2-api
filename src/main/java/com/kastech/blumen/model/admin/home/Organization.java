package com.kastech.blumen.model.admin.home;

import com.google.common.collect.Sets;
import com.kastech.blumen.model.keycloak.LoggedUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Organization" ,schema = "blumen2")
public class Organization implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long orgId;
    private String orgName;
    private String orgCode;
    private String orgDescription;
    private String orgBulkTemplate;
    private Boolean orgTwoFactor;
    private Boolean orgDeviceAuth;
    private Boolean orgSendMail;
    private Integer orgExpiryTime;
    private Boolean orgActive;
    private Boolean orgSiteLocation;
    private Boolean orgScript;
    private Boolean orgTrioBlumenLab;
    private Boolean orgPurge;
    private Boolean deleted;

    private String orgAddress1;
    private String orgAddress2;
    private String orgProgramType;
    private String orgOrganizationType;
    private Integer orgDaysToExpire;
    private Integer orgRemindOne;
    private Integer orgRemindTwo;
    private String orgCity;
    private String orgState;
    private Integer orgZipCode;

    private Integer orgPhoneOne;
    private Integer orgPhoneTwo;
    private Integer orgPhoneThree;
    private String mailServer;
    private Integer orgFax;

    private String orgWebSite;
    private String orgEmail;
    private String orgUserName;
    private String orgDirector;
    private String orgGoodTill;
    private String orgNotes;

    private String orgNavigateToUser;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Organization_users",schema = "blumen2",
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<LoggedUser> users = Sets.newHashSet();

    public Organization() {
    }

    public Organization(Long orgId, String orgName, String orgCode, String orgDescription, String orgBulkTemplate, Boolean orgTwoFactor, Boolean orgDeviceAuth, Boolean orgSendMail, Integer orgExpiryTime, Boolean orgActive, Boolean orgSiteLocation, Boolean orgScript, Boolean orgTrioBlumenLab, Boolean orgPurge, Boolean deleted, String orgAddress1, String orgAddress2, String orgProgramType, String orgOrganizationType, Integer orgDaysToExpire, Integer orgRemindOne, Integer orgRemindTwo, String orgCity, String orgState, Integer orgZipCode, Integer orgPhoneOne, Integer orgPhoneTwo, Integer orgPhoneThree, String mailServer, Integer orgFax, String orgWebSite, String orgEmail, String orgUserName, String orgDirector, String orgGoodTill, String orgNotes, String orgNavigateToUser, Set<LoggedUser> users) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.orgDescription = orgDescription;
        this.orgBulkTemplate = orgBulkTemplate;
        this.orgTwoFactor = orgTwoFactor;
        this.orgDeviceAuth = orgDeviceAuth;
        this.orgSendMail = orgSendMail;
        this.orgExpiryTime = orgExpiryTime;
        this.orgActive = orgActive;
        this.orgSiteLocation = orgSiteLocation;
        this.orgScript = orgScript;
        this.orgTrioBlumenLab = orgTrioBlumenLab;
        this.orgPurge = orgPurge;
        this.deleted = deleted;
        this.orgAddress1 = orgAddress1;
        this.orgAddress2 = orgAddress2;
        this.orgProgramType = orgProgramType;
        this.orgOrganizationType = orgOrganizationType;
        this.orgDaysToExpire = orgDaysToExpire;
        this.orgRemindOne = orgRemindOne;
        this.orgRemindTwo = orgRemindTwo;
        this.orgCity = orgCity;
        this.orgState = orgState;
        this.orgZipCode = orgZipCode;
        this.orgPhoneOne = orgPhoneOne;
        this.orgPhoneTwo = orgPhoneTwo;
        this.orgPhoneThree = orgPhoneThree;
        this.mailServer = mailServer;
        this.orgFax = orgFax;
        this.orgWebSite = orgWebSite;
        this.orgEmail = orgEmail;
        this.orgUserName = orgUserName;
        this.orgDirector = orgDirector;
        this.orgGoodTill = orgGoodTill;
        this.orgNotes = orgNotes;
        this.orgNavigateToUser = orgNavigateToUser;
        this.users = users;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgBulkTemplate() {
        return orgBulkTemplate;
    }

    public void setOrgBulkTemplate(String orgBulkTemplate) {
        this.orgBulkTemplate = orgBulkTemplate;
    }

    public Boolean getOrgTwoFactor() {
        return orgTwoFactor;
    }

    public void setOrgTwoFactor(Boolean orgTwoFactor) {
        this.orgTwoFactor = orgTwoFactor;
    }

    public Boolean getOrgDeviceAuth() {
        return orgDeviceAuth;
    }

    public void setOrgDeviceAuth(Boolean orgDeviceAuth) {
        this.orgDeviceAuth = orgDeviceAuth;
    }

    public Boolean getOrgSendMail() {
        return orgSendMail;
    }

    public void setOrgSendMail(Boolean orgSendMail) {
        this.orgSendMail = orgSendMail;
    }

    public Integer getOrgExpiryTime() {
        return orgExpiryTime;
    }

    public void setOrgExpiryTime(Integer orgExpiryTime) {
        this.orgExpiryTime = orgExpiryTime;
    }

    public Boolean getOrgActive() {
        return orgActive;
    }

    public void setOrgActive(Boolean orgActive) {
        this.orgActive = orgActive;
    }

    public Boolean getOrgSiteLocation() {
        return orgSiteLocation;
    }

    public void setOrgSiteLocation(Boolean orgSiteLocation) {
        this.orgSiteLocation = orgSiteLocation;
    }

    public Boolean getOrgScript() {
        return orgScript;
    }

    public void setOrgScript(Boolean orgScript) {
        this.orgScript = orgScript;
    }

    public Boolean getOrgTrioBlumenLab() {
        return orgTrioBlumenLab;
    }

    public void setOrgTrioBlumenLab(Boolean orgTrioBlumenLab) {
        this.orgTrioBlumenLab = orgTrioBlumenLab;
    }

    public Boolean getOrgPurge() {
        return orgPurge;
    }

    public void setOrgPurge(Boolean orgPurge) {
        this.orgPurge = orgPurge;
    }

    public String getOrgAddress1() {
        return orgAddress1;
    }

    public void setOrgAddress1(String orgAddress1) {
        this.orgAddress1 = orgAddress1;
    }

    public String getOrgAddress2() {
        return orgAddress2;
    }

    public void setOrgAddress2(String orgAddress2) {
        this.orgAddress2 = orgAddress2;
    }

    public String getOrgProgramType() {
        return orgProgramType;
    }

    public void setOrgProgramType(String orgProgramType) {
        this.orgProgramType = orgProgramType;
    }

    public String getOrgOrganizationType() {
        return orgOrganizationType;
    }

    public void setOrgOrganizationType(String orgOrganizationType) {
        this.orgOrganizationType = orgOrganizationType;
    }

    public Integer getOrgDaysToExpire() {
        return orgDaysToExpire;
    }

    public void setOrgDaysToExpire(Integer orgDaysToExpire) {
        this.orgDaysToExpire = orgDaysToExpire;
    }

    public Integer getOrgRemindOne() {
        return orgRemindOne;
    }

    public void setOrgRemindOne(Integer orgRemindOne) {
        this.orgRemindOne = orgRemindOne;
    }

    public Integer getOrgRemindTwo() {
        return orgRemindTwo;
    }

    public void setOrgRemindTwo(Integer orgRemindTwo) {
        this.orgRemindTwo = orgRemindTwo;
    }

    public String getOrgCity() {
        return orgCity;
    }

    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity;
    }

    public String getOrgState() {
        return orgState;
    }

    public void setOrgState(String orgState) {
        this.orgState = orgState;
    }

    public Integer getOrgZipCode() {
        return orgZipCode;
    }

    public void setOrgZipCode(Integer orgZipCode) {
        this.orgZipCode = orgZipCode;
    }

    public Integer getOrgPhoneOne() {
        return orgPhoneOne;
    }

    public void setOrgPhoneOne(Integer orgPhoneOne) {
        this.orgPhoneOne = orgPhoneOne;
    }

    public Integer getOrgPhoneTwo() {
        return orgPhoneTwo;
    }

    public void setOrgPhoneTwo(Integer orgPhoneTwo) {
        this.orgPhoneTwo = orgPhoneTwo;
    }

    public Integer getOrgPhoneThree() {
        return orgPhoneThree;
    }

    public void setOrgPhoneThree(Integer orgPhoneThree) {
        this.orgPhoneThree = orgPhoneThree;
    }

    public String getMailServer() {
        return mailServer;
    }

    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }

    public Integer getOrgFax() {
        return orgFax;
    }

    public void setOrgFax(Integer orgFax) {
        this.orgFax = orgFax;
    }

    public String getOrgWebSite() {
        return orgWebSite;
    }

    public void setOrgWebSite(String orgWebSite) {
        this.orgWebSite = orgWebSite;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public String getOrgUserName() {
        return orgUserName;
    }

    public void setOrgUserName(String orgUserName) {
        this.orgUserName = orgUserName;
    }

    public String getOrgDirector() {
        return orgDirector;
    }

    public void setOrgDirector(String orgDirector) {
        this.orgDirector = orgDirector;
    }

    public String getOrgGoodTill() {
        return orgGoodTill;
    }

    public void setOrgGoodTill(String orgGoodTill) {
        this.orgGoodTill = orgGoodTill;
    }

    public String getOrgNotes() {
        return orgNotes;
    }

    public void setOrgNotes(String orgNotes) {
        this.orgNotes = orgNotes;
    }

    public String getOrgNavigateToUser() {
        return orgNavigateToUser;
    }

    public void setOrgNavigateToUser(String orgNavigateToUser) {
        this.orgNavigateToUser = orgNavigateToUser;
    }

    public Set<LoggedUser> getUsers() {
        return users;
    }

    public void setUsers(Set<LoggedUser> users) {
        this.users = users;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgDescription='" + orgDescription + '\'' +
                ", orgBulkTemplate='" + orgBulkTemplate + '\'' +
                ", orgTwoFactor='" + orgTwoFactor + '\'' +
                ", orgDeviceAuth='" + orgDeviceAuth + '\'' +
                ", orgSendMail='" + orgSendMail + '\'' +
                ", orgExpiryTime=" + orgExpiryTime +
                ", orgActive='" + orgActive + '\'' +
                ", orgSiteLocation='" + orgSiteLocation + '\'' +
                ", orgScript='" + orgScript + '\'' +
                ", orgTrioBlumenLab='" + orgTrioBlumenLab + '\'' +
                ", orgPurge='" + orgPurge + '\'' +
                ", orgAddress1='" + orgAddress1 + '\'' +
                ", orgAddress2='" + orgAddress2 + '\'' +
                ", orgProgramType='" + orgProgramType + '\'' +
                ", orgOrganizationType='" + orgOrganizationType + '\'' +
                ", orgDaysToExpire=" + orgDaysToExpire +
                ", orgRemindOne=" + orgRemindOne +
                ", orgRemindTwo=" + orgRemindTwo +
                ", orgCity='" + orgCity + '\'' +
                ", orgState='" + orgState + '\'' +
                ", orgZipCode=" + orgZipCode +
                ", orgPhoneOne=" + orgPhoneOne +
                ", orgPhoneTwo=" + orgPhoneTwo +
                ", orgPhoneThree=" + orgPhoneThree +
                ", mailServer='" + mailServer + '\'' +
                ", orgFax=" + orgFax +
                ", orgWebSite='" + orgWebSite + '\'' +
                ", orgEmail='" + orgEmail + '\'' +
                ", orgUserName='" + orgUserName + '\'' +
                ", orgDirector='" + orgDirector + '\'' +
                ", orgGoodTill='" + orgGoodTill + '\'' +
                ", orgNotes='" + orgNotes + '\'' +
                ", orgNavigateToUser='" + orgNavigateToUser + '\'' +
                '}';
    }
}