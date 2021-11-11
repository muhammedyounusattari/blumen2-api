package com.kastech.blumen.model;

public class SystemPreferences {

	private DefaultSetting defaultSetting;
	private ReportSettings reportSetting;
	private AnnualPerformance annualPerformance;

	public SystemPreferences(DefaultSetting defaultSetting, ReportSettings reportSetting,
			AnnualPerformance annualPerformance) {
		super();
		this.defaultSetting = defaultSetting;
		this.reportSetting = reportSetting;
		this.annualPerformance = annualPerformance;
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
