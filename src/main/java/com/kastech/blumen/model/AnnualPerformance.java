package com.kastech.blumen.model;

public class AnnualPerformance {

	private String projectDirector;
	private String institutionName;
	private String reportingPeriodFrom;
	private String reportingPeriodTo;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phone1;
	private String ext;
	private String fax;
	private String prAwardNumber;
	private String ombApprNumb;
	private String programType;
	private String expDate;
	private String fundedToServe;
	private String fundToServeRatioThreshould;
	private String fundToServeRatioThreshouldTo;

	public AnnualPerformance(String projectDirector, String institutionName, String reportingPeriodFrom,
			String reportingPeriodTo, String address, String city, String state, String zipCode, String phone1,
			String ext, String fax, String prAwardNumber, String ombApprNumb, String programType, String expDate,
			String fundedToServe, String fundToServeRatioThreshould, String fundToServeRatioThreshouldTo) {
		super();
		this.projectDirector = projectDirector;
		this.institutionName = institutionName;
		this.reportingPeriodFrom = reportingPeriodFrom;
		this.reportingPeriodTo = reportingPeriodTo;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone1 = phone1;
		this.ext = ext;
		this.fax = fax;
		this.prAwardNumber = prAwardNumber;
		this.ombApprNumb = ombApprNumb;
		this.programType = programType;
		this.expDate = expDate;
		this.fundedToServe = fundedToServe;
		this.fundToServeRatioThreshould = fundToServeRatioThreshould;
		this.fundToServeRatioThreshouldTo = fundToServeRatioThreshouldTo;
	}

	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getReportingPeriodFrom() {
		return reportingPeriodFrom;
	}

	public void setReportingPeriodFrom(String reportingPeriodFrom) {
		this.reportingPeriodFrom = reportingPeriodFrom;
	}

	public String getReportingPeriodTo() {
		return reportingPeriodTo;
	}

	public void setReportingPeriodTo(String reportingPeriodTo) {
		this.reportingPeriodTo = reportingPeriodTo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPrAwardNumber() {
		return prAwardNumber;
	}

	public void setPrAwardNumber(String prAwardNumber) {
		this.prAwardNumber = prAwardNumber;
	}

	public String getOmbApprNumb() {
		return ombApprNumb;
	}

	public void setOmbApprNumb(String ombApprNumb) {
		this.ombApprNumb = ombApprNumb;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getFundedToServe() {
		return fundedToServe;
	}

	public void setFundedToServe(String fundedToServe) {
		this.fundedToServe = fundedToServe;
	}

	public String getFundToServeRatioThreshould() {
		return fundToServeRatioThreshould;
	}

	public void setFundToServeRatioThreshould(String fundToServeRatioThreshould) {
		this.fundToServeRatioThreshould = fundToServeRatioThreshould;
	}

	public String getFundToServeRatioThreshouldTo() {
		return fundToServeRatioThreshouldTo;
	}

	public void setFundToServeRatioThreshouldTo(String fundToServeRatioThreshouldTo) {
		this.fundToServeRatioThreshouldTo = fundToServeRatioThreshouldTo;
	}

	@Override
	public String toString() {
		return "AnnualPerformance [projectDirector=" + projectDirector + ", institutionName=" + institutionName
				+ ", reportingPeriodFrom=" + reportingPeriodFrom + ", reportingPeriodTo=" + reportingPeriodTo
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", phone1="
				+ phone1 + ", ext=" + ext + ", fax=" + fax + ", prAwardNumber=" + prAwardNumber + ", ombApprNumb="
				+ ombApprNumb + ", programType=" + programType + ", expDate=" + expDate + ", fundedToServe="
				+ fundedToServe + ", fundToServeRatioThreshould=" + fundToServeRatioThreshould
				+ ", fundToServeRatioThreshouldTo=" + fundToServeRatioThreshouldTo + "]";
	}

}
