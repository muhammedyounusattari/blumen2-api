package com.kastech.blumen.service.customize;

import com.kastech.blumen.constants.ErrorMessageConstants;
import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.admin.home.PullType;
import com.kastech.blumen.model.customize.PullDownMaster;
import com.kastech.blumen.model.customize.PullDownMasterCreateRequest;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.LoggedUserRepository;

import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.repository.admin.home.PullTypeRepository;
import com.kastech.blumen.repository.customize.PullDownMasterRepository;
import com.kastech.blumen.repository.student.configurations.OrganizationTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class PullDownMasterServiceV1 {

    @Autowired
    private PullDownMasterRepository pullDownMasterRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private OrganizationTypeRepository organizationTypeRepository;

    @Autowired
    private PullTypeRepository pullTypeRepository;
    @Autowired
    private LoggedUserRepository loggedUserRepository;


    public List<PullDownMaster> getPullDownList (Long orgId, String pullType,Long projType){
        if(projType == null){
            projType = findOrganizationType(orgId);
        }
        return pullDownMasterRepository.findByOrganizationidAndPulltypeAndDeletedAndProjtypeOrderByIdAsc(orgId,pullType,false,projType);
    }

    public PullDownMaster savePullDownMaster (PullDownMasterCreateRequest pullDownMasterCreateRequest){
        List<String> errors = validateCreate(pullDownMasterCreateRequest);
        if(!CollectionUtils.isEmpty(errors)){
            throw new ServiceLayerException(String.join(",",errors));
        }
        PullDownMaster pullDownMaster = new PullDownMaster();

        BeanUtils.copyProperties(pullDownMasterCreateRequest, pullDownMaster);
        List<PullType> pullTypeList = pullTypeRepository.findByPullType(pullDownMasterCreateRequest.getPulltype());
        if(! CollectionUtils.isEmpty(pullTypeList)) {
            pullDownMaster.setNumeric(pullTypeList.get(0).getNumeric());
        }

        if(pullDownMasterCreateRequest.getProjtype() == null){
            pullDownMaster.setProjtype(findOrganizationType(pullDownMasterCreateRequest.getOrganizationid()));
        }
        pullDownMaster.setDeleted(false);
        pullDownMaster.setLastmodify(new Date());
        pullDownMaster.setTimestamp_column(new Date());
        pullDownMaster.setLastuser(pullDownMasterCreateRequest.getUserName());
        //pullDownMaster.setLongpullna(pullDownMasterCreateRequest.getPullname());
        //pullDownMaster.setPullname(null);
        return pullDownMasterRepository.save(pullDownMaster);
    }

    public PullDownMaster updatePullDownMaster (PullDownMaster pullDownMaster){
        List<String> errors = validateUpdate(pullDownMaster);
        if(!CollectionUtils.isEmpty(errors)){
            throw new ServiceLayerException(String.join(",",errors));
        }
        pullDownMaster.setLastmodify(new Date());
        pullDownMaster.setTimestamp_column(new Date());
        return pullDownMasterRepository.save(pullDownMaster);
    }

    public void  deletePullDownMaster (PullDownMaster pullDownMaster){
        pullDownMaster.setDeleted(true);
         pullDownMasterRepository.save(pullDownMaster);
    }

    public Long findOrganizationType(Long orgId){
        Long projType = null;
        Optional<Organization>  organization = organizationRepository.findById(orgId);
        if(organization.isPresent()) {
            List<OrganizationType> organizationTypeList = organizationTypeRepository.findByOrgType(organization.get().getOrgOrganizationType());
            if(!CollectionUtils.isEmpty(organizationTypeList)){
                projType = organizationTypeList.get(0).getId();
            }
        }

        return projType;
    }
    public List<String> validateCreate(PullDownMasterCreateRequest pullDownMasterCreateRequest){
        List<String> errorMessages = new ArrayList<>();
        Optional<LoggedUser>  user = loggedUserRepository.findByUsernameAndOrgId(pullDownMasterCreateRequest.getUserName(),pullDownMasterCreateRequest.getOrganizationid());
        List<PullType> pullTypeList = pullTypeRepository.findByPullType(pullDownMasterCreateRequest.getPulltype());
        List<PullDownMaster> pullDownMasterList = pullDownMasterRepository.
                findByOrganizationidAndPulltypeAndPullId(pullDownMasterCreateRequest.getOrganizationid(),
                        pullDownMasterCreateRequest.getPulltype(),pullDownMasterCreateRequest.getPullId());
        Optional<Organization> organization = organizationRepository.findById(pullDownMasterCreateRequest.getOrganizationid());
        if(!CollectionUtils.isEmpty(pullDownMasterList)){
            PullDownMaster pullDownMasterFromDb = pullDownMasterList.get(0);
            if(pullDownMasterFromDb.getDeleted()){
                errorMessages.add(ErrorMessageConstants.PULL_DOWN_ALREADY_DELETED_NUMBER);
            }
            else{
                errorMessages.add(ErrorMessageConstants.PULL_DOWN_ALREADY_EXISTS_WITH_NUMBER);
            }
        }

        if(CollectionUtils.isEmpty(pullTypeList)) {
            errorMessages.add(ErrorMessageConstants.INVALID_PULL_TYPE);
        }
        if(pullDownMasterCreateRequest.getProjtype() != null){
           boolean isPresent =  organizationTypeRepository.findById(pullDownMasterCreateRequest.getProjtype()  ).isPresent();
           if(!isPresent){
               errorMessages.add(ErrorMessageConstants.INVALID_PROJ_TYPE);
           }
        }
        if(! organization.isPresent()){
            errorMessages.add(ErrorMessageConstants.INVALID_ORGANIZATION_ID);
        }

         if(! user.isPresent()){
             errorMessages.add(ErrorMessageConstants.INVALID_USER_NAME);
         }


        return errorMessages;
    }


    public List<String> validateUpdate(PullDownMaster pullDownMaster){
        List<String> errorMessages = new ArrayList<>();
        Optional<LoggedUser>  user = loggedUserRepository.findByUsernameAndOrgId(pullDownMaster.getLastuser(),pullDownMaster.getOrganizationid());
        List<PullType> pullTypeList = pullTypeRepository.findByPullType(pullDownMaster.getPulltype());

        Optional<Organization> organization = organizationRepository.findById(pullDownMaster.getOrganizationid());

        List<PullDownMaster> pullDownMasterList = pullDownMasterRepository.
                findByOrganizationidAndPulltypeAndPullId(pullDownMaster.getOrganizationid(),
                        pullDownMaster.getPulltype(),pullDownMaster.getPullId());
        if(CollectionUtils.isEmpty(pullTypeList)) {
            errorMessages.add(ErrorMessageConstants.INVALID_PULL_TYPE);
        }
        if(pullDownMaster.getProjtype() != null){
            boolean isPresent =  organizationTypeRepository.findById(pullDownMaster.getProjtype()  ).isPresent();
            if(!isPresent){
                errorMessages.add(ErrorMessageConstants.INVALID_PROJ_TYPE);
            }
        }
        if(! organization.isPresent()){
            errorMessages.add(ErrorMessageConstants.INVALID_ORGANIZATION_ID);
        }

        if(! user.isPresent()){
            errorMessages.add(ErrorMessageConstants.INVALID_USER_NAME);
        }

        if(!CollectionUtils.isEmpty(pullDownMasterList)){
            PullDownMaster pullDownMasterFromDb = pullDownMasterList.get(0);
            if(pullDownMaster.getPullId() != pullDownMasterFromDb.getPullId()) {
                if (pullDownMasterFromDb.getDeleted()) {
                    errorMessages.add(ErrorMessageConstants.PULL_DOWN_ALREADY_DELETED_NUMBER);
                } else {
                    errorMessages.add(ErrorMessageConstants.PULL_DOWN_ALREADY_EXISTS_WITH_NUMBER);
                }
            }
        }

        return errorMessages;
    }

    public Map<String ,List<PullDownMaster>> getMultiPullDownMaster(Long orgId, String pullType, Long projType){
        Map<String ,List<PullDownMaster>> pullDownMasterMap = new LinkedHashMap<>();
        if(projType == null){
            projType = findOrganizationType(orgId);
        }
        for (String pullTypeVal : pullType.split(",")) {
            pullDownMasterMap.put(pullTypeVal,pullDownMasterRepository.findByOrganizationidAndPulltypeAndDeletedAndProjtypeOrderByIdAsc(orgId,pullTypeVal,false,projType));
        }

        return pullDownMasterMap;
    }
}
