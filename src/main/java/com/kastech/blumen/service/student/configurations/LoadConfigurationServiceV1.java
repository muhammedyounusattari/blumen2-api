package com.kastech.blumen.service.student.configurations;

import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.repository.customize.PullDownItemsRepository;
import com.kastech.blumen.repository.customize.PullDownListRepository;
import com.kastech.blumen.repository.student.configurations.OrganizationTypeRepository;
import com.kastech.blumen.service.customize.PullDownListServiceV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadConfigurationServiceV1 {

    @Autowired
    private OrganizationTypeRepository organizationTypeRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListServiceV1.class);

    public List<OrganizationType> getConfiguration(String orgType)
    {
        return organizationTypeRepository.findByOrgType(orgType);
    }
}
