package com.kastech.blumen.service.home;

import com.kastech.blumen.constants.ErrorMessageConstants;
import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.model.admin.home.PullType;
import com.kastech.blumen.model.admin.home.PullTypeMultiSearchRequest;
import com.kastech.blumen.model.admin.home.PullTypeSearchRequest;
import com.kastech.blumen.repository.admin.home.PullTypeRepository;
import com.kastech.blumen.repository.student.configurations.OrganizationTypeRepository;
import com.kastech.blumen.service.customize.PullDownMasterServiceV1;
import com.kastech.blumen.utility.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

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

    @Autowired
    private OrganizationTypeRepository organizationTypeRepository;

    @Autowired
    private PullDownMasterServiceV1 pullDownMasterServiceV1;


    public List<PullType> findPullTypesList(PullTypeSearchRequest pullTypeSearchRequest) {
        return pullTypeRepository.findByPullDescStartsWithIgnoreCaseAndPullTypeStartsWithIgnoreCaseAndProjType
                (pullTypeSearchRequest.getDescription() != null ? pullTypeSearchRequest.getDescription() + "%" : "%",
                        pullTypeSearchRequest.getPullType() != null ? pullTypeSearchRequest.getPullType() + "%" : "%", pullTypeSearchRequest.getProgramType());
    }

    public PullType updatePullType(PullType pullType) {
        if(pullType.getProjType() != null){
            boolean isPresent = organizationTypeRepository.findById(pullType.getProjType()).isPresent();
            if(!isPresent){
                throw  new ServiceLayerException(ErrorMessageConstants.INVALID_PROJ_TYPE);
            }
        }
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

    public Map<String, List<PullType>> findPullTypesList(PullTypeMultiSearchRequest pullTypeSearchRequest) {
        Map<String, List<PullType>> pullTypeMap = new LinkedHashMap<>();
        if(pullTypeSearchRequest.getPullType() != null){
            String[] pullTypes = pullTypeSearchRequest.getPullType().split(",");

            Arrays.stream(pullTypes).forEach(pulltype -> {
                if(pullTypeSearchRequest.getProgramType() != null){
                    pullTypeMap.put(pulltype, pullTypeRepository.findByPullTypeAndProjType(pulltype, pullTypeSearchRequest.getProgramType()));
                }
                else{
                    pullTypeMap.put(pulltype,pullTypeRepository.findByPullType(pulltype));
                }
                    }
            );
        }
        return pullTypeMap;
    }

    public List<PullType> findPullTypesList(Long orgId) {
        OrganizationType programType =pullDownMasterServiceV1.findOrganizationType(orgId);
        return pullTypeRepository.findByPullDescStartsWithIgnoreCaseAndPullTypeStartsWithIgnoreCaseAndProjType
                ( "%", "%", programType.getId());
    }
}
