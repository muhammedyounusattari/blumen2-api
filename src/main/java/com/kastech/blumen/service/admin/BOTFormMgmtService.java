package com.kastech.blumen.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kastech.blumen.model.AnnualPerformance;
import com.kastech.blumen.model.ConfigSettings;
import com.kastech.blumen.model.admin.BOTMgmtForm;
import com.kastech.blumen.repository.admin.AnnualPerformanceRepository;
import com.kastech.blumen.repository.admin.ConfigSettingRepository;


@Component
public class BOTFormMgmtService {

	@Autowired
	ConfigSettingRepository configSettingRepository;
	
	@Autowired
	AnnualPerformanceRepository annualPerformanceRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BOTFormMgmtService.class);

	public AnnualPerformance saveSystemPreferenceData(AnnualPerformance annualPerformance) {
		LOGGER.info("Inside BotFormMgmtService ");		
		return annualPerformanceRepository.save(annualPerformance)	;	
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
		return configSettingRepository.findAll();
	}
	
	
}
