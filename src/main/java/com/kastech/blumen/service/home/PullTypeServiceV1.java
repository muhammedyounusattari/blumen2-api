package com.kastech.blumen.service.home;

import com.kastech.blumen.model.admin.home.PullType;
import com.kastech.blumen.model.admin.home.PullTypeSearchRequest;
import com.kastech.blumen.repository.admin.home.PullTypeRepository;
import com.kastech.blumen.utility.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PullTypeServiceV1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(PullTypeServiceV1.class);
    private static final String PULL_DESC =  "pulldesc";
    private static final String PULL_TYPE =  "pulltype";
    private static final String NUMERIC =  "numeric";
    private static final String APR =  "apr";
    private static final String NO_EDIT =  "noedit";
    private static final String DATA_FIELDS =  "datafields";
    private static  final String SER_TYPE = "sertype";
    private static  final String PROJ_TYPE = "projtype";
    private static  final String SORT_ORDER = "sortorder";
    private static  final String QUICK_EDIT_DESC = "quickeditdesc";
    private static  final String PRIMARY = "primary";

    private final List<String> headerNames = new ArrayList<>();

    PullTypeServiceV1() {
        headerNames.add(PULL_DESC);
        headerNames.add(PULL_TYPE);
        headerNames.add(NUMERIC);
        headerNames.add(APR);
        headerNames.add(NO_EDIT);
        headerNames.add(DATA_FIELDS);
        headerNames.add(SER_TYPE);
        headerNames.add(PROJ_TYPE);
        headerNames.add(SORT_ORDER);
        headerNames.add(QUICK_EDIT_DESC);
        headerNames.add(PRIMARY);
    }

    @Autowired
    private PullTypeRepository pullTypeRepository;

    public List<PullType> findPullTypesList(PullTypeSearchRequest pullTypeSearchRequest) {
        return pullTypeRepository.findByPullDescStartsWithIgnoreCaseAndPullTypeStartsWithIgnoreCaseAndProjType
                (pullTypeSearchRequest.getDescription() != null ? pullTypeSearchRequest.getDescription() + "%" : "%",
                        pullTypeSearchRequest.getPullType() != null ? pullTypeSearchRequest.getPullType() + "%" : "%", pullTypeSearchRequest.getProgramType());
    }

    public PullType updatePullType(PullType pullType) {
        return pullTypeRepository.save(pullType);
    }

    public ByteArrayOutputStream downloadPullType(PullTypeSearchRequest pullTypeSearchRequest) throws IOException {
        ByteArrayOutputStream bos = null;
        ExcelUtil excelUtil = new ExcelUtil();
        List<PullType> pullTypes = pullTypeRepository.findByPullDescStartsWithIgnoreCaseAndPullTypeStartsWithIgnoreCaseAndProjType
                (pullTypeSearchRequest.getDescription() != null ? pullTypeSearchRequest.getDescription() + "%" : "%",
                        pullTypeSearchRequest.getPullType() != null ? pullTypeSearchRequest.getPullType() + "%" : "%", pullTypeSearchRequest.getProgramType());
        Sheet sheet = excelUtil.getSheet("PullType");
        excelUtil.createHeaders(sheet, headerNames);
        if (!CollectionUtils.isEmpty(pullTypes)) {
            excelUtil.generatePullTypeExcelReport(sheet, pullTypes);
        }
        bos = excelUtil.getByteArrayOutputStream(sheet);
        return bos;
    }

}
