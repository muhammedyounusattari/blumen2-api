package com.kastech.blumen.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kastech.blumen.model.AnnualPerformance;
import com.kastech.blumen.model.BOTMgmtForm;
import com.kastech.blumen.model.ConfigSettings;
import com.kastech.blumen.repository.admin.BOTFormMgmtRepository;


@Component
public class BOTFormMgmtService {

	@Autowired
	BOTFormMgmtRepository botFormMgmtRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BOTFormMgmtService.class);

	public void saveSystemPreferenceData(AnnualPerformance annualPerformance) {
		LOGGER.info("Inside BotFormMgmtService ");		
		//here repository code willcome
		//repository.		
	}

	public List<BOTMgmtForm> getBOTMgmtFormList() {
		BOTMgmtForm botMgmtForm1 = new BOTMgmtForm(1, "text1", "10", new Date());
		BOTMgmtForm botMgmtForm2 = new BOTMgmtForm(2, "text2", "11", new Date());
		List<BOTMgmtForm> botMgmtForms = new ArrayList<>();
		botMgmtForms.add(botMgmtForm1);
		botMgmtForms.add(botMgmtForm2);
		return botMgmtForms;
	}

	public List<ConfigSettings>  getConfigSettingList() {
		ConfigSettings configSetting1 = new ConfigSettings(1, "configValue1", "configType1", "description text1");
		ConfigSettings configSetting2 = new ConfigSettings(2, "configValue2", "configType3", "description text2");
		List<ConfigSettings> configSettings = new ArrayList<>();
		configSettings.add(configSetting1);
		configSettings.add(configSetting2);
		return configSettings;
	}
	
	
}
