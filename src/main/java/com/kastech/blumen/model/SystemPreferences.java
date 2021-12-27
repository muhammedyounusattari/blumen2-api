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
@Table(name = "system_preferences" ,schema = "blumen2")
public class SystemPreferences {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="system_preferences_seq_gen")
    @SequenceGenerator(name="system_preferences_seq_gen", sequenceName="SYSTEM_PREFERENCES_SEQ")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private DefaultSetting defaultSetting;
	@OneToOne(cascade = CascadeType.ALL)
	private ReportSettings reportSetting;
	@OneToOne(cascade = CascadeType.ALL)
	private AnnualPerformance annualPerformance;

	public SystemPreferences() {}
	
	public SystemPreferences(DefaultSetting defaultSetting, ReportSettings reportSetting,
			AnnualPerformance annualPerformance) {
		super();
		this.defaultSetting = defaultSetting;
		this.reportSetting = reportSetting;
		this.annualPerformance = annualPerformance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DefaultSetting getDefaultSetting() {
		return defaultSetting;
	}

	public void setDefaultSetting(DefaultSetting defaultSetting) {
		this.defaultSetting = defaultSetting;
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
		return "SystemPreferences [defaultSetting=" + defaultSetting + ", reportSetting=" + reportSetting
				+ ", annualPerformance=" + annualPerformance + "]";
	}

}
