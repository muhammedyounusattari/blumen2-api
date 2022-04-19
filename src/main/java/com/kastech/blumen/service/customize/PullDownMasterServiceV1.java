package com.kastech.blumen.service.customize;

import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.admin.home.PullType;
import com.kastech.blumen.model.customize.PullDownMaster;
import com.kastech.blumen.model.customize.PullDownMasterCreateRequest;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.repository.admin.home.PullTypeRepository;
import com.kastech.blumen.repository.customize.PullDownMasterRepository;
import com.kastech.blumen.repository.student.configurations.OrganizationTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PullDownMasterServiceV1 {
    private static final String PULL_DOWN_ALREADY_EXISTS_WITH_NUMBER = "A pulldown already exists for this number.";
    private static final String PULL_DOWN_ALREADY_DELETED_NUMBER = "The pulldown was deleted for this number.";
    private static final String INVALID_PULL_TYPE = "PULL TYPE IS INVALID";

    @Autowired
    private PullDownMasterRepository pullDownMasterRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private OrganizationTypeRepository organizationTypeRepository;

    @Autowired
    private PullTypeRepository pullTypeRepository;

    public List<PullDownMaster> getPullDownList (Long orgId, String pullType,Long projType){
        if(projType == null){
            projType = findOrganizationType(orgId);
        }
        return pullDownMasterRepository.findByOrganizationidAndPulltypeAndDeletedAndProjtypeOrderByIdAsc(orgId,pullType,false,projType);
    }

    public PullDownMaster savePullDownMaster (PullDownMasterCreateRequest pullDownMasterCreateRequest){
        PullDownMaster pullDownMaster = new PullDownMaster();
        List<PullDownMaster> pullDownMasterList = pullDownMasterRepository.findByOrganizationidAndPulltypeAndPullId(pullDownMasterCreateRequest.getOrganizationid(), pullDownMaster.getPulltype(),pullDownMaster.getPullId());
        if(!CollectionUtils.isEmpty(pullDownMasterList)){
            PullDownMaster pullDownMasterFromDb = pullDownMasterList.get(0);
            if(pullDownMasterFromDb.getDeleted()){
                throw new ServiceLayerException(PULL_DOWN_ALREADY_DELETED_NUMBER);
            }
            else{
                throw new ServiceLayerException(PULL_DOWN_ALREADY_EXISTS_WITH_NUMBER);
            }
        }
        BeanUtils.copyProperties(pullDownMasterCreateRequest, pullDownMaster);
        List<PullType> pullTypeList = pullTypeRepository.findByPullType(pullDownMasterCreateRequest.getPulltype());
        if(! CollectionUtils.isEmpty(pullTypeList)) {
            pullDownMaster.setNumeric(pullTypeList.get(0).getNumeric());
        }
        else{
            throw new ServiceLayerException(INVALID_PULL_TYPE);
        }
        if(pullDownMasterCreateRequest.getProjtype() == null){
            pullDownMaster.setProjtype(findOrganizationType(pullDownMasterCreateRequest.getOrganizationid()));
        }
        pullDownMaster.setDeleted(false);
        pullDownMaster.setLastmodify(new Date());
        pullDownMaster.setTimestamp_column(new Date());
        pullDownMaster.setLastuser(pullDownMasterCreateRequest.getUserName());

        return pullDownMasterRepository.save(pullDownMaster);
    }

    public PullDownMaster updatePullDownMaster (PullDownMaster pullDownMaster){
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
}
