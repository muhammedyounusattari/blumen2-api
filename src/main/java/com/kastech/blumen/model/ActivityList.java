package com.kastech.blumen.model;

public class ActivityList {

    private String activityId;
    private String activityName;
    private String activityGroupName;
    private String activityAdd;
    private String activityBoltService;
    private boolean lapService;

    public ActivityList() {
    }

    public ActivityList(String activityId, String activityName, String activityGroupName, String activityAdd, String activityBoltService, boolean lapService) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityGroupName = activityGroupName;
        this.activityAdd = activityAdd;
        this.activityBoltService = activityBoltService;
        this.lapService = lapService;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
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

    @Override
    public String toString() {
        return "ActivityList{" +
                "activityId='" + activityId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityGroupName='" + activityGroupName + '\'' +
                ", activityAdd='" + activityAdd + '\'' +
                ", activityBoltService='" + activityBoltService + '\'' +
                ", lapService=" + lapService +
                '}';
    }
}
