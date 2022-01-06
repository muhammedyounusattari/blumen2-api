package com.kastech.blumen.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	
	private boolean copyPreviousData;
	private boolean studentActive;
	private boolean studentServed;
	private boolean studentReported;
	private boolean addStudentToFiscalYear;
	private boolean updateFirstDateOfService;
	private boolean updateLastDateOfService;
	
	@Column
	//@ElementCollection(targetClass=Integer.class)
	private String gpaScale;
	
	@Column
  //  @ElementCollection(targetClass=String.class)
	private String stateTest;
	private String ageCalculator;
	private String siteLocation;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isCopyPreviousData() {
		return copyPreviousData;
	}
	public void setCopyPreviousData(boolean copyPreviousData) {
		this.copyPreviousData = copyPreviousData;
	}
	public boolean isStudentActive() {
		return studentActive;
	}
	public void setStudentActive(boolean studentActive) {
		this.studentActive = studentActive;
	}
	public boolean isStudentServed() {
		return studentServed;
	}
	public void setStudentServed(boolean studentServed) {
		this.studentServed = studentServed;
	}
	public boolean isStudentReported() {
		return studentReported;
	}
	public void setStudentReported(boolean studentReported) {
		this.studentReported = studentReported;
	}
	public boolean isAddStudentToFiscalYear() {
		return addStudentToFiscalYear;
	}
	public void setAddStudentToFiscalYear(boolean addStudentToFiscalYear) {
		this.addStudentToFiscalYear = addStudentToFiscalYear;
	}
	public boolean isUpdateFirstDateOfService() {
		return updateFirstDateOfService;
	}
	public void setUpdateFirstDateOfService(boolean updateFirstDateOfService) {
		this.updateFirstDateOfService = updateFirstDateOfService;
	}
	public boolean isUpdateLastDateOfService() {
		return updateLastDateOfService;
	}
	public void setUpdateLastDateOfService(boolean updateLastDateOfService) {
		this.updateLastDateOfService = updateLastDateOfService;
	}

	public String getGpaScale() {
		return gpaScale;
	}

	public void setGpaScale(String gpaScale) {
		this.gpaScale = gpaScale;
	}

	public String getAgeCalculator() {
		return ageCalculator;
	}
	public void setAgeCalculator(String ageCalculator) {
		this.ageCalculator = ageCalculator;
	}
	public String getSiteLocation() {
		return siteLocation;
	}
	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;
	}
	
}
