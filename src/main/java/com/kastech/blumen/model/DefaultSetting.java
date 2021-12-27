package com.kastech.blumen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "default_setting" ,schema = "blumen2")
public class DefaultSetting {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="default_setting_seq_gen")
    @SequenceGenerator(name="default_setting_seq_gen", sequenceName="DEFAULT_SETTING_SEQ")
	private Long id;
	private String fiscalYear;
	private String currentYear;
	private String semester;
	private String component;
	
	public DefaultSetting() {
		super();
	}

	public DefaultSetting(String fiscalYear, String currentYear, String semester, String component) {
		super();
		this.fiscalYear = fiscalYear;
		this.currentYear = currentYear;
		this.semester = semester;
		this.component = component;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
