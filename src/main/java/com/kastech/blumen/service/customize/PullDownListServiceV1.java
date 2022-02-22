package com.kastech.blumen.service.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.model.customize.PullDownItem;
import com.kastech.blumen.repository.customize.PullDownItemsRepository;
import com.kastech.blumen.repository.customize.PullDownListRepository;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PullDownListServiceV1 {

    @Autowired
    private PullDownItemsRepository pullDownItemRepository;

    @Autowired
    private PullDownListRepository pullDownListRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListServiceV1.class);

    public PullDown doService(String reqBody) {
        LOGGER.info("inside doService of {}", this.getClass());
        return CommonUtil.convertJsonStringToPojoForPullDown(reqBody);
    }

    public List<PullDownItem> getPullDownItemsByCode(String code) {
        LOGGER.info("inside doService of {}", this.getClass());
        List<PullDown> pullDownItems = pullDownListRepository.findByCode(code);
        if (!pullDownItems.isEmpty()) {
            return pullDownItemRepository.findByPulldownId(pullDownItems.get(0).getId());
        }

        return null;
    }

    public List<PullDown> getPullDownList(Sort id) {
        LOGGER.info("inside doService of {}", this.getClass());
        return pullDownListRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }


    public List<PullDownItem> getPulldownValidate(Integer pullId, Long pulldownId) {
        LOGGER.info("inside doService of {}", this.getClass());
        return pullDownItemRepository.findByIdAndPullId(pullId, pulldownId);
    }

    public PullDown getPullDownListById(Long id) {
        LOGGER.info("inside doService of {}", this.getClass());
        Optional<PullDown> pullDown = pullDownListRepository.findById(id);
        if (!pullDown.isEmpty()) {
            return pullDown.get();
        }
        return new PullDown();
    }

    public List<PullDownItem> getPullDownItemsById(Long id) {
        LOGGER.info("inside doService of {}", this.getClass());
        return pullDownItemRepository.findByPulldownId(id);
    }

    public PullDown editPullDownList(PullDown pullDown) {
        return pullDownListRepository.save(pullDown);
    }


    public PullDownItem editPullDownItem(PullDownItem pullDown) {
        return pullDownItemRepository.save(pullDown);
    }

    public List<PullDown> getPullDownListByType(String type) {
        return pullDownListRepository.findByType(type);
    }


    public List<PullDown> getPullDownListByCode(String code) {
        return pullDownListRepository.findByCode(code);
    }

    public void deletePullDownList(PullDownItem pullDownItem) {
        pullDownItemRepository.delete(pullDownItem);
    }

    public Map<String, String> checkPullDownItemInUse(PullDown pullDown) {
        List<PullDownItem> pullDownItemLst = pullDown.getpullDownItems();
        Map<String, String> statusMap = new HashMap<>();
        if (!pullDownItemLst.isEmpty()) {
            PullDownItem pullDownItem = pullDownItemLst.get(0);
            if (pullDownItem.getId() != null && pullDownItem.getPullId() != null && !pullDownItemRepository.findByIdAndPullId(pullDownItem.getPullId(), pullDownItem.getId()).isEmpty()) {
                statusMap.put("message", "Id is already in use, either you can edit or revoke it");
                statusMap.put("status", "404");
                return statusMap;
            }
        }
        statusMap.put("message", "PullDownItem payload is missing");
        statusMap.put("status", "404");
        return statusMap;
    }

    public PullDown addToPullDownList(PullDown pullDown) {
        return pullDownListRepository.save(pullDown);
    }

    public ResponseEntity<?> addPullDownItem(Long id, PullDownItem pullDownItems) {

        Map<String, String> statusMap = new HashMap<>();
        PullDown pulldown = pullDownListRepository.findById(id).get();
        if (pulldown != null && pullDownItems.getPullId() != null && pullDownItemRepository.findByIdAndPullId(pullDownItems.getPullId(), id).isEmpty()) {
            return ResponseEntity.ok(pullDownItemRepository.save(pullDownItems));
        } else {
            return new ResponseEntity(new Response(200, "Pullid " + pullDownItems.getPullId() + "is already in use"), null, HttpStatus.OK);
        }
    }

    public Map<String, List<PullDownItem>> getPullDownListByCodes(List<String> codes) {
        LOGGER.info("inside getPullDownListByCodes() of {}", this.getClass());
        List<PullDown> pullDownItems = pullDownListRepository.findMultiplePulldownListByCodes(codes);
        Map<String, List<PullDownItem>> pulldownItems = new LinkedHashMap<>();
        if (!pullDownItems.isEmpty()) {
            for (PullDown pullDown : pullDownItems) {
                pulldownItems.put(pullDown.getCode(), pullDownItemRepository.findByPulldownId(pullDown.getId()));
            }
        }
        return pulldownItems;
    }
}
