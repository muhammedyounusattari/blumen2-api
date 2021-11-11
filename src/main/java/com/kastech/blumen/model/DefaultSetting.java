package com.kastech.blumen.model;

public class DefaultSetting {

	private String fiscalYear;
	private String currentYear;
	private String semester;
	private String component;
	
	
	
	public DefaultSetting(String fiscalYear, String currentYear, String semester, String component) {
		super();
		this.fiscalYear = fiscalYear;
		this.currentYear = currentYear;
		this.semester = semester;
		this.component = component;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	@Override
	public String toString() {
		return "DefaultSetting [fiscalYear=" + fiscalYear + ", currentYear=" + currentYear + ", semester=" + semester
				+ ", component=" + component + "]";
	}
	
	
}
