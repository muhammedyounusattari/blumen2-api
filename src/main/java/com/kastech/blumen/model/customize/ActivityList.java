package com.kastech.blumen.model.customize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity_list", schema = "blumen2")
public class ActivityList {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="activity_list_seq_gen")
    @SequenceGenerator(name="activity_list_seq_gen", sequenceName="ACTIVITY_LIST_SEQ")
    private long activityId;
    private String activityName;
    private String activityGroupName;
    private String activityAdd;
    private String activityBoltService;
    private boolean lapService;

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


    public ActivityList() {
    }

    public ActivityList(long activityId, String activityName, String activityGroupName, String activityAdd, String activityBoltService, boolean lapService
            ,Date createdDate,long createdBy,Date modifiedDate,long modifiedBy,Date deletedDate,long deletedBy,long orgId, long id, long tempId) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityGroupName = activityGroupName;
        this.activityAdd = activityAdd;
        this.activityBoltService = activityBoltService;
        this.lapService = lapService;
        this.createdDate=createdDate;
        this.createdBy=createdBy;
        this.modifiedDate=modifiedDate;
        this.deletedDate=deletedDate;
        this.modifiedBy=modifiedBy;
        this.deletedBy=deletedBy;
        this.orgId=orgId;
        this.id=id;
        this.tempId=tempId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityGroupName() {
        return activityGroupName;
    }

    public void setActivityGroupName(String activityGroupName) {
        this.activityGroupName = activityGroupName;
    }

    public boolean isLapService() {
        return lapService;
    }

    public void setLapService(boolean lapService) {
        this.lapService = lapService;
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
        return "ActivityList{" +
                "activityId='" + activityId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityGroupName='" + activityGroupName + '\'' +
                ", activityAdd='" + activityAdd + '\'' +
                ", activityBoltService='" + activityBoltService + '\'' +
                ", lapService=" + lapService + '\'' +
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

    public ActivityList updateWith(ActivityList item) {
        return new ActivityList(
                this.activityId,
                item.activityName,
                item.activityGroupName,
                item.activityAdd,
                item.activityBoltService,
                item.lapService,
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
