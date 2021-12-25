package com.kastech.blumen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "report_setting" ,schema = "blumen2")
public class ReportSettings {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="report_setting_seq_gen")
    @SequenceGenerator(name="report_setting_seq_gen", sequenceName="report_SETTING_SEQ")
	private Long id;
	private String reportTitle;
	private String reportTitle2;
	private String report_Footer;
	
	
	
	public ReportSettings() {
		super();
	}
	
	public ReportSettings(String reportTitle, String reportTitle2, String report_Footer) {
		super();
		this.reportTitle = reportTitle;
		this.reportTitle2 = reportTitle2;
		this.report_Footer = report_Footer;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportTitle2() {
		return reportTitle2;
	}

	public void setReportTitle2(String reportTitle2) {
		this.reportTitle2 = reportTitle2;
	}

	public String getReport_Footer() {
		return report_Footer;
	}

	public void setReport_Footer(String report_Footer) {
		this.report_Footer = report_Footer;
	}

	@Override
	public String toString() {
		return "ReportSettings [reportTitle=" + reportTitle + ", reportTitle2=" + reportTitle2 + ", report_Footer="
				+ report_Footer + "]";
	}

}
