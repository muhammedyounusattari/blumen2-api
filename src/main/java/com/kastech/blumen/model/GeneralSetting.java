package com.kastech.blumen.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "general_setting" ,schema = "blumen2")
public class GeneralSetting {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="general_setting_seq_gen")
    @SequenceGenerator(name="general_setting_seq_gen", sequenceName="GENERAL_SETTING_SEQ")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private GeneralDefaultSetting generalDefaultSetting;
	@OneToOne(cascade = CascadeType.ALL)
	private ReportSettings reportSetting;
	@OneToOne(cascade = CascadeType.ALL)
	private AnnualPerformance annualPerformance;

	public GeneralSetting() {}
	
	public GeneralSetting(GeneralDefaultSetting generalDefaultSetting, ReportSettings reportSetting,
			AnnualPerformance annualPerformance) {
		super();
		this.generalDefaultSetting = generalDefaultSetting;
		this.reportSetting = reportSetting;
		this.annualPerformance = annualPerformance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GeneralDefaultSetting getDefaultSetting() {
		return generalDefaultSetting;
	}

	public void setDefaultSetting(GeneralDefaultSetting generalDefaultSetting) {
		this.generalDefaultSetting = generalDefaultSetting;
	}

	public ReportSettings getReportSetting() {
		return reportSetting;
	}

	public void setReportSetting(ReportSettings reportSetting) {
		this.reportSetting = reportSetting;
	}

	public AnnualPerformance getAnnualPerformance() {
		return annualPerformance;
	}

	public void setAnnualPerformance(AnnualPerformance annualPerformance) {
		this.annualPerformance = annualPerformance;
	}

	@Override
	public String toString() {
		return "SystemPreferences [defaultSetting=" + generalDefaultSetting + ", reportSetting=" + reportSetting
				+ ", annualPerformance=" + annualPerformance + "]";
	}

}
