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
    @SequenceGenerator(name="system_preferences_seq_gen", sequenceName="system_preferences_SEQ")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private GeneralSetting generalSetting;
	@OneToOne(cascade = CascadeType.ALL)
	private DefaultSetting defaultSetting;
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
	
	
}
