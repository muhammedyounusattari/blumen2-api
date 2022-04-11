package com.kastech.blumen.model;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "config_setting" ,schema = "blumen2")
public class ConfigSettings implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer configId;

	private String configType;
	private String configValue; 
	private String description;

	@Column(nullable = false)
	private String organisationType;

	@Column(nullable = false)
	private String orgId;

	@Column(nullable = true)
	private String users;

	public ConfigSettings() {}

	public ConfigSettings(Long id, Integer configId, String configType, String configValue, String description, String origanisationType, String users) {
		this.id = id;
		this.configId = configId;
		this.configType = configType;
		this.configValue = configValue;
		this.description = description;
		this.organisationType = origanisationType;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOriganisationType() {
		return organisationType;
	}

	public void setOriganisationType(String origanisationType) {
		this.organisationType = origanisationType;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Override
	public String toString() {
		return "ConfigSettings{" +
				"id=" + id +
				", configId=" + configId +
				", configType='" + configType + '\'' +
				", configValue='" + configValue + '\'' +
				", description='" + description + '\'' +
				", origanisationType='" + organisationType + '\'' +
				", users='" + users + '\'' +
				'}';
	}
}
