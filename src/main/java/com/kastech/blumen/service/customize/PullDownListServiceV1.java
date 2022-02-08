package com.kastech.blumen.service.customize;

import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.model.customize.PullDownItem;
import com.kastech.blumen.repository.customize.PullDownItemsRepository;
import com.kastech.blumen.repository.customize.PullDownListRepository;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PullDownListServiceV1 {

    @Autowired
    private PullDownItemsRepository pullDownItemsRepository;

    @Autowired
    private PullDownListRepository pullDownListRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListServiceV1.class);

    public PullDown doService(String reqBody){

        PullDown pullDown = CommonUtil.convertJsonStringToPojoForPullDown(reqBody);


        return pullDown;
    }

    public List<PullDownItem> getPullDownItemsByCode(String code) {

        List<PullDown> pullDownItems = pullDownListRepository.findByCode(code);
        if(!pullDownItems.isEmpty()){
          return  pullDownItemsRepository.findByPulldownId(pullDownItems.get(0).getId());
        }

        return null;
    }
}
