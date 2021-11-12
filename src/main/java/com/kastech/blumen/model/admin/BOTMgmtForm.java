package com.kastech.blumen.model.admin;

import java.util.Date;

public class BOTMgmtForm {

	private Integer formId;
	private String formName;
	private String submissionCount;
	private Date   goLiveDate;
	
	public BOTMgmtForm(Integer formId, String formName, String submissionCount, Date goLiveDate) {
		super();
		this.formId = formId;
		this.formName = formName;
		this.submissionCount = submissionCount;
		this.goLiveDate = goLiveDate;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getSubmissionCount() {
		return submissionCount;
	}

	public void setSubmissionCount(String submissionCount) {
		this.submissionCount = submissionCount;
	}

	public Date getGoLiveDate() {
		return goLiveDate;
	}

	public void setGoLiveDate(Date goLiveDate) {
		this.goLiveDate = goLiveDate;
	}

	@Override
	public String toString() {
		return "BOTMgmtForm [formId=" + formId + ", formName=" + formName + ", submissionCount=" + submissionCount
				+ ", goLiveDate=" + goLiveDate + "]";
	}
	
	
}
