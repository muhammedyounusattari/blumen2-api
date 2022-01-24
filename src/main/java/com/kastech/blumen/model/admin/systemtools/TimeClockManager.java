package com.kastech.blumen.model.admin.systemtools;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "time_clock_manager" ,schema = "blumen2")
public class TimeClockManager implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="time_clock_manager_seq_gen")
    @SequenceGenerator(name="time_clock_manager_seq_gen", sequenceName="TIME_CLOCK_MANAGER_SEQ")
    private Long id;
    private String staffId;
    private String staffName;
    private String checkInTime;
    private String checkOutTime;
    private String duration;
    private String statusInOut;

    public TimeClockManager() {
    }

    public TimeClockManager(Long id, String staffId, String staffName, String checkInTime, String checkOutTime, String duration, String statusInOut) {
        this.id = id;
        this.staffId = staffId;
        this.staffName = staffName;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.duration = duration;
        this.statusInOut = statusInOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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

    public String getStatusInOut() {
        return statusInOut;
    }

    public void setStatusInOut(String statusInOut) {
        this.statusInOut = statusInOut;
    }

    @Override
    public String toString() {
        return "TimeClockManager{" +
                "id=" + id +
                ", staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", checkOutTime='" + checkOutTime + '\'' +
                ", duration='" + duration + '\'' +
                ", statusInOut='" + statusInOut + '\'' +
                '}';
    }

    public TimeClockManager updateWith(TimeClockManager item) {
        return new TimeClockManager(
                this.id,
                item.staffId,
                item.staffName,
                item.checkInTime,
                item.checkOutTime,
                item.duration,
                item.statusInOut
        );
    }
}
