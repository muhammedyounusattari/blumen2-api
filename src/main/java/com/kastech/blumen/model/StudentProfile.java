package com.kastech.blumen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_profile",schema = "blumen2")
public class StudentProfile {

	@Id
	private Long profileId;
    private String reportHeader;
    private String fiscalYear;
    private String active;
    private String served;
    private String reported;
    private String ethinicity;
    private String eligibility;
    private String gender;
    private String zipCode;
    private String incomeSource;
    private String entryDateFrom;
    private String entryDateTo;
    private String month;
    private String referredBy;
    private String cohortYear;
    private String school;
    private String counselor;
    private String standing;
    private String entrySchool;
    private String entryCollege;
    private String collegeType;
    private String collegeName;
    private String major;
    private String siteLocation;
    private String collegeReady;
    private String participantStatus;
    private String codes;
    private String advisor;
    private String tutor;
    private String customOne;
    private String customTwo;
    private String customThree;
    private String customFour;
    private String graduationCohortYear;
    private String gpaEntry;
    private String gpaEntryStart;
    private String gpaEntryEnd;

    public StudentProfile() {
    }

    public StudentProfile(String reportHeader, String fiscalYear, String active, String served, String reported, String ethinicity, String eligibility, String gender, String zipCode, String incomeSource, String entryDateFrom, String entryDateTo, String month, String referredBy, String cohortYear, String school, String counselor, String standing, String entrySchool, String entryCollege, String collegeType, String collegeName, String major, String siteLocation, String collegeReady, String participantStatus, String codes, String advisor, String tutor, String customOne, String customTwo, String customThree, String customFour, String graduationCohortYear, String gpaEntry, String gpaEntryStart, String gpaEntryEnd) {
        this.reportHeader = reportHeader;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.ethinicity = ethinicity;
        this.eligibility = eligibility;
        this.gender = gender;
        this.zipCode = zipCode;
        this.incomeSource = incomeSource;
        this.entryDateFrom = entryDateFrom;
        this.entryDateTo = entryDateTo;
        this.month = month;
        this.referredBy = referredBy;
        this.cohortYear = cohortYear;
        this.school = school;
        this.counselor = counselor;
        this.standing = standing;
        this.entrySchool = entrySchool;
        this.entryCollege = entryCollege;
        this.collegeType = collegeType;
        this.collegeName = collegeName;
        this.major = major;
        this.siteLocation = siteLocation;
        this.collegeReady = collegeReady;
        this.participantStatus = participantStatus;
        this.codes = codes;
        this.advisor = advisor;
        this.tutor = tutor;
        this.customOne = customOne;
        this.customTwo = customTwo;
        this.customThree = customThree;
        this.customFour = customFour;
        this.graduationCohortYear = graduationCohortYear;
        this.gpaEntry = gpaEntry;
        this.gpaEntryStart = gpaEntryStart;
        this.gpaEntryEnd = gpaEntryEnd;
    }

    public String getReportHeader() {
        return reportHeader;
    }

    public void setReportHeader(String reportHeader) {
        this.reportHeader = reportHeader;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getServed() {
        return served;
    }

    public void setServed(String served) {
        this.served = served;
    }

    public String getReported() {
        return reported;
    }

    public void setReported(String reported) {
        this.reported = reported;
    }

    public String getEthinicity() {
        return ethinicity;
    }

    public void setEthinicity(String ethinicity) {
        this.ethinicity = ethinicity;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public String getEntryDateFrom() {
        return entryDateFrom;
    }

    public void setEntryDateFrom(String entryDateFrom) {
        this.entryDateFrom = entryDateFrom;
    }

    public String getEntryDateTo() {
        return entryDateTo;
    }

    public void setEntryDateTo(String entryDateTo) {
        this.entryDateTo = entryDateTo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getCohortYear() {
        return cohortYear;
    }

    public void setCohortYear(String cohortYear) {
        this.cohortYear = cohortYear;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public String getEntrySchool() {
        return entrySchool;
    }

    public void setEntrySchool(String entrySchool) {
        this.entrySchool = entrySchool;
    }

    public String getEntryCollege() {
        return entryCollege;
    }

    public void setEntryCollege(String entryCollege) {
        this.entryCollege = entryCollege;
    }

    public String getCollegeType() {
        return collegeType;
    }

    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public String getCollegeReady() {
        return collegeReady;
    }

    public void setCollegeReady(String collegeReady) {
        this.collegeReady = collegeReady;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(String participantStatus) {
        this.participantStatus = participantStatus;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getCustomOne() {
        return customOne;
    }

    public void setCustomOne(String customOne) {
        this.customOne = customOne;
    }

    public String getCustomTwo() {
        return customTwo;
    }

    public void setCustomTwo(String customTwo) {
        this.customTwo = customTwo;
    }

    public String getCustomThree() {
        return customThree;
    }

    public void setCustomThree(String customThree) {
        this.customThree = customThree;
    }

    public String getCustomFour() {
        return customFour;
    }

    public void setCustomFour(String customFour) {
        this.customFour = customFour;
    }

    public String getGraduationCohortYear() {
        return graduationCohortYear;
    }

    public void setGraduationCohortYear(String graduationCohortYear) {
        this.graduationCohortYear = graduationCohortYear;
    }

    public String getGpaEntry() {
        return gpaEntry;
    }

    public void setGpaEntry(String gpaEntry) {
        this.gpaEntry = gpaEntry;
    }

    public String getGpaEntryStart() {
        return gpaEntryStart;
    }

    public void setGpaEntryStart(String gpaEntryStart) {
        this.gpaEntryStart = gpaEntryStart;
    }

    public String getGpaEntryEnd() {
        return gpaEntryEnd;
    }

    public void setGpaEntryEnd(String gpaEntryEnd) {
        this.gpaEntryEnd = gpaEntryEnd;
    }
    
    public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	@Override
    public String toString() {
        return "StudentProfile{" +
                "reportHeader='" + reportHeader + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", active='" + active + '\'' +
                ", served='" + served + '\'' +
                ", reported='" + reported + '\'' +
                ", ethinicity='" + ethinicity + '\'' +
                ", eligibility='" + eligibility + '\'' +
                ", gender='" + gender + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", incomeSource='" + incomeSource + '\'' +
                ", entryDateFrom='" + entryDateFrom + '\'' +
                ", entryDateTo='" + entryDateTo + '\'' +
                ", month='" + month + '\'' +
                ", referredBy='" + referredBy + '\'' +
                ", cohortYear='" + cohortYear + '\'' +
                ", school='" + school + '\'' +
                ", counselor='" + counselor + '\'' +
                ", standing='" + standing + '\'' +
                ", entrySchool='" + entrySchool + '\'' +
                ", entryCollege='" + entryCollege + '\'' +
                ", collegeType='" + collegeType + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", major='" + major + '\'' +
                ", siteLocation='" + siteLocation + '\'' +
                ", collegeReady='" + collegeReady + '\'' +
                ", participantStatus='" + participantStatus + '\'' +
                ", codes='" + codes + '\'' +
                ", advisor='" + advisor + '\'' +
                ", tutor='" + tutor + '\'' +
                ", customOne='" + customOne + '\'' +
                ", customTwo='" + customTwo + '\'' +
                ", customThree='" + customThree + '\'' +
                ", customFour='" + customFour + '\'' +
                ", graduationCohortYear='" + graduationCohortYear + '\'' +
                ", gpaEntry='" + gpaEntry + '\'' +
                ", gpaEntryStart='" + gpaEntryStart + '\'' +
                ", gpaEntryEnd='" + gpaEntryEnd + '\'' +
                '}';
    }
}
