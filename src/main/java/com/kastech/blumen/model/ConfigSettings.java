package com.kastech.blumen.model;

public class ConfigSettings {

	private Integer configID;
	private String configType;
	private String configValue; 
	private String description;
	
	public ConfigSettings(Integer configID, String configType, String configValue, String description) {
		super();
		this.configID = configID;
		this.configType = configType;
		this.configValue = configValue;
		this.description = description;
	}

	public Integer getConfigID() {
		return configID;
	}

	public void setConfigID(Integer configID) {
		this.configID = configID;
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
		return "ConfigSettings [configID=" + configID + ", configType=" + configType + ", configValue=" + configValue
				+ ", description=" + description + "]";
	}
	
	
	
}
