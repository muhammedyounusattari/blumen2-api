package com.kastech.blumen.model;

public class ActivityGroupList {

    private String activityGroupId;
    private String activityGroupName;
    private boolean activityCalculateHoursforActivityGroup;
    private boolean activityReportActivityGroup;
    private String activityGroupType;
    private String activityGroupTypeName;
    private String activityAdd;
    private String activityBoltService;

    public ActivityGroupList() {
    }

    public ActivityGroupList(String activityGroupId, String activityGroupName, boolean activityCalculateHoursforActivityGroup, boolean activityReportActivityGroup, String activityGroupType, String activityGroupTypeName, String activityAdd, String activityBoltService) {
        this.activityGroupId = activityGroupId;
        this.activityGroupName = activityGroupName;
        this.activityCalculateHoursforActivityGroup = activityCalculateHoursforActivityGroup;
        this.activityReportActivityGroup = activityReportActivityGroup;
        this.activityGroupType = activityGroupType;
        this.activityGroupTypeName = activityGroupTypeName;
        this.activityAdd = activityAdd;
        this.activityBoltService = activityBoltService;
    }

    public String getActivityGroupId() {
        return activityGroupId;
    }

    public void setActivityGroupId(String activityGroupId) {
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
}
