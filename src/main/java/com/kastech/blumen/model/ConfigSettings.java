package com.kastech.blumen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config_setting" ,schema = "blumen2")
public class ConfigSettings {

	@Id
	private Long id;
	private String configType;
	private String configValue; 
	private String description;
	
	public ConfigSettings() {}
	
	public ConfigSettings(Long id, String configType, String configValue, String description) {
		super();
		this.id = id;
		this.configType = configType;
		this.configValue = configValue;
		this.description = description;
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "ConfigSettings [id=" + id + ", configType=" + configType + ", configValue=" + configValue
				+ ", description=" + description + "]";
	}
	
	
	
}
