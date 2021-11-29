package com.kastech.blumen.model.admin.systemtools;

public class TimeClockManager {

    private String id;
    private String staffName;
    private String checkInTime;
    private String checkOutTime;
    private String duration;

    public TimeClockManager() {
    }

    public TimeClockManager(String id, String staffName, String checkInTime, String checkOutTime, String duration) {
        this.staffName = staffName;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.duration = duration;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "TimeClockManager{" +
                "id='" + id + '\'' +
                ", staffName='" + staffName + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", checkOutTime='" + checkOutTime + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
