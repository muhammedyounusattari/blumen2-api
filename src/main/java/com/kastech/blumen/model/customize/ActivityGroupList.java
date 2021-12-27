package com.kastech.blumen.model.customize;

import javax.persistence.*;

@Entity
@Table(name = "activity_group_list", schema = "blumen2")
public class ActivityGroupList {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="activity_grp_list_seq_gen")
    @SequenceGenerator(name="activity_grp_list_seq_gen", sequenceName="ACTIVITY_GROUP_LIST_SEQ")
    private Long activityGroupId;
    private String activityGroupName;
    private boolean activityCalculateHoursforActivityGroup;
    private boolean activityReportActivityGroup;
    private String activityGroupType;
    private String activityGroupTypeName;
    private String activityAdd;
    private String activityBoltService;

    public ActivityGroupList() {
    }

    public ActivityGroupList(Long activityGroupId, String activityGroupName, boolean activityCalculateHoursforActivityGroup, boolean activityReportActivityGroup, String activityGroupType, String activityGroupTypeName, String activityAdd, String activityBoltService) {
        this.activityGroupId = activityGroupId;
        this.activityGroupName = activityGroupName;
        this.activityCalculateHoursforActivityGroup = activityCalculateHoursforActivityGroup;
        this.activityReportActivityGroup = activityReportActivityGroup;
        this.activityGroupType = activityGroupType;
        this.activityGroupTypeName = activityGroupTypeName;
        this.activityAdd = activityAdd;
        this.activityBoltService = activityBoltService;
    }

    public Long getActivityGroupId() {
        return activityGroupId;
    }

    public void setActivityGroupId(Long activityGroupId) {
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
                item.activityBoltService
        );
    }
}
