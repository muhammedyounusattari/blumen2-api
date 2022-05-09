package com.kastech.blumen.model;

import javax.persistence.*;

@Entity
@Table(name = "system_preferences" ,schema = "blumen2")
public class SystemPreferences {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private GeneralSetting generalSetting;
	@OneToOne(cascade = CascadeType.ALL)
	private DefaultSetting defaultSetting;

	@Column(unique = true,nullable = false)
	private Long orgId;

	@Column(nullable = true)
	private Long modifiedBy;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public GeneralSetting getGeneralSetting() {
		return generalSetting;
	}
	public void setGeneralSetting(GeneralSetting generalSetting) {
		this.generalSetting = generalSetting;
	}
	public DefaultSetting getDefaultSetting() {
		return defaultSetting;
	}
	public void setDefaultSetting(DefaultSetting defaultSetting) {
		this.defaultSetting = defaultSetting;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
