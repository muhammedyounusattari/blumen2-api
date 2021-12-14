package com.kastech.blumen.model.customize;

import javax.persistence.*;

@Entity
@Table(name = "activity_list", schema = "blumen2")
public class ActivityList {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="activity_list_seq_gen")
    @SequenceGenerator(name="activity_list_seq_gen", sequenceName="ACTIVITY_LIST_SEQ")
    private Long activityId;
    private String activityName;
    private String activityGroupName;
    private String activityAdd;
    private String activityBoltService;
    private boolean lapService;

    public ActivityList() {
    }

    public ActivityList(Long activityId, String activityName, String activityGroupName, String activityAdd, String activityBoltService, boolean lapService) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityGroupName = activityGroupName;
        this.activityAdd = activityAdd;
        this.activityBoltService = activityBoltService;
        this.lapService = lapService;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
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

    public ActivityList updateWith(ActivityList item) {
        return new ActivityList(
                this.activityId,
                item.activityName,
                item.activityGroupName,
                item.activityAdd,
                item.activityBoltService,
                item.lapService
        );
    }
}
