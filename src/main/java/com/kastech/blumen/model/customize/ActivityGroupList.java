package com.kastech.blumen.model.customize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity_group_list", schema = "blumen2")
public class ActivityGroupList {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="activity_grp_list_seq_gen")
    @SequenceGenerator(name="activity_grp_list_seq_gen", sequenceName="ACTIVITY_GROUP_LIST_SEQ")
    private long activityGroupId;
    private String activityGroupName;
    private boolean activityCalculateHoursforActivityGroup;
    private boolean activityReportActivityGroup;
    private String activityGroupType;
    private String activityGroupTypeName;
    private String activityAdd;
    private String activityBoltService;

    private Date createdDate;
    private long createdBy;
    private Date modifiedDate;
    private long modifiedBy;
    private Date deletedDate;
    private long deletedBy;
    private long orgId;
    private long id;

    @Transient
    private long tempId;


    public ActivityGroupList() {
    }

    public ActivityGroupList(long activityGroupId, String activityGroupName, boolean activityCalculateHoursforActivityGroup, boolean activityReportActivityGroup, String activityGroupType, String activityGroupTypeName, String activityAdd, String activityBoltService
     ,Date createdDate,long createdBy,Date modifiedDate,long modifiedBy,Date deletedDate,long deletedBy,long orgId, long id, long tempId) {
        this.activityGroupId = activityGroupId;
        this.activityGroupName = activityGroupName;
        this.activityCalculateHoursforActivityGroup = activityCalculateHoursforActivityGroup;
        this.activityReportActivityGroup = activityReportActivityGroup;
        this.activityGroupType = activityGroupType;
        this.activityGroupTypeName = activityGroupTypeName;
        this.activityAdd = activityAdd;
        this.activityBoltService = activityBoltService;
        this.createdDate=createdDate;
        this.createdBy=createdBy;
        this.modifiedDate=modifiedDate;
        this.deletedDate=deletedDate;
        this.modifiedBy=modifiedBy;
        this.deletedBy=deletedBy;
        this.orgId=orgId;
        this.id = id;
        this.tempId = tempId;
    }

    public long getActivityGroupId() {
        return activityGroupId;
    }

    public void setActivityGroupId(long activityGroupId) {
        this.activityGroupId = activityGroupId;
    }

    public String getActivityGroupName() {
        return activityGroupName;
    }

    public void setActivityGroupName(String activityGroupName) {
        this.activityGroupName = activityGroupName;
    }

    public boolean isActivityCalculateHoursforActivityGroup() {
        return activityCalculateHoursforActivityGroup;
    }

    public void setActivityCalculateHoursforActivityGroup(boolean activityCalculateHoursforActivityGroup) {
        this.activityCalculateHoursforActivityGroup = activityCalculateHoursforActivityGroup;
    }

    public boolean isActivityReportActivityGroup() {
        return activityReportActivityGroup;
    }

    public void setActivityReportActivityGroup(boolean activityReportActivityGroup) {
        this.activityReportActivityGroup = activityReportActivityGroup;
    }

    public String getActivityGroupType() {
        return activityGroupType;
    }

    public void setActivityGroupType(String activityGroupType) {
        this.activityGroupType = activityGroupType;
    }

    public String getActivityGroupTypeName() {
        return activityGroupTypeName;
    }

    public void setActivityGroupTypeName(String activityGroupTypeName) {
        this.activityGroupTypeName = activityGroupTypeName;
    }

    public String getActivityAdd() {
        return activityAdd;
    }

    public void setActivityAdd(String activityAdd) {
        this.activityAdd = activityAdd;
    }

    public String getActivityBoltService() {
        return activityBoltService;
    }

    public void setActivityBoltService(String activityBoltService) {
        this.activityBoltService = activityBoltService;
    }

    public Date getCreatedDate() {return createdDate;}

    public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}

    public long getCreatedBy() {return createdBy;}

    public void setCreatedBy(long createdBy) {this.createdBy = createdBy;}

    public Date getModifiedDate() {return modifiedDate;}

    public void setModifiedDate(Date modifiedDate) {this.modifiedDate = modifiedDate;}

    public long getModifiedBy() {return modifiedBy;}

    public void setModifiedBy(long modifiedBy) {this.modifiedBy = modifiedBy;}

    public Date getDeletedDate() {return deletedDate;}

    public void setDeletedDate(Date deletedDate) {this.deletedDate = deletedDate;}

    public long getDeletedBy() {return deletedBy;}

    public void setDeletedBy(long deletedBy) {this.deletedBy = deletedBy;}

    public long getOrgId() {return orgId;}

    public void setOrgId(long orgId) {this.orgId = orgId;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getTempId() {return tempId;}

    public void setTempId(long tempId) {this.tempId = tempId;}

    @Override
    public String toString() {
        return "ActivityGroupList{" +
                "activityGroupId='" + activityGroupId + '\'' +
                ", activityGroupName='" + activityGroupName + '\'' +
                ", activityCalculateHoursforActivityGroup=" + activityCalculateHoursforActivityGroup +
                ", activityReportActivityGroup=" + activityReportActivityGroup +
                ", activityGroupType='" + activityGroupType + '\'' +
                ", activityGroupTypeName='" + activityGroupTypeName + '\'' +
                ", activityAdd='" + activityAdd + '\'' +
                ", activityBoltService='" + activityBoltService + '\'' +

                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", deletedDate='" + deletedDate + '\'' +
                ", deletedBy='" + deletedBy + '\'' +
                ", orgId='" + orgId +
                ", id='" + id +
                ", tempId='" + tempId +
                '}';
    }

    public ActivityGroupList updateWith(ActivityGroupList item) {
        return new ActivityGroupList(
                this.activityGroupId,
                item.activityGroupName,
                item.activityCalculateHoursforActivityGroup,
                item.activityReportActivityGroup,
                item.activityGroupType,
                item.activityGroupTypeName,
                item.activityAdd,
                item.activityBoltService,
                item.createdDate,
                item.createdBy,
                item.modifiedDate,
                item.modifiedBy,
                item.deletedDate,
                item.deletedBy,
                item.orgId,
                item.id,
                item.tempId
        );
    }
}
