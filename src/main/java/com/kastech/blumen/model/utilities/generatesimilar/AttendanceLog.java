package com.kastech.blumen.model.utilities.generatesimilar;

import javax.persistence.*;

@Entity
@Table(name = "attendance_log", schema = "blumen2")
public class AttendanceLog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="attendance_log_list_seq_gen")
    @SequenceGenerator(name="attendance_log_list_seq_gen", sequenceName="ATTENDANCE_LOG_LIST_SEQ")
    private Long id;
    private String attendanceDate;
    private boolean attendanceChecked;
    private String attendanceAmount;
    private String attendanceNote;

    public AttendanceLog() {
    }

    public AttendanceLog(Long id, String attendanceDate, boolean attendanceChecked, String attendanceAmount, String attendanceNote) {
        this.id = id;
        this.attendanceDate = attendanceDate;
        this.attendanceChecked = attendanceChecked;
        this.attendanceAmount = attendanceAmount;
        this.attendanceNote = attendanceNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public boolean isAttendanceChecked() {
        return attendanceChecked;
    }

    public void setAttendanceChecked(boolean attendanceChecked) {
        this.attendanceChecked = attendanceChecked;
    }

    public String getAttendanceAmount() {
        return attendanceAmount;
    }

    public void setAttendanceAmount(String attendanceAmount) {
        this.attendanceAmount = attendanceAmount;
    }

    public String getAttendanceNote() {
        return attendanceNote;
    }

    public void setAttendanceNote(String attendanceNote) {
        this.attendanceNote = attendanceNote;
    }

    @Override
    public String toString() {
        return "AttendanceLog{" +
                "id=" + id +
                ", attendanceDate='" + attendanceDate + '\'' +
                ", attendanceChecked=" + attendanceChecked +
                ", attendanceAmount='" + attendanceAmount + '\'' +
                ", attendanceNote='" + attendanceNote + '\'' +
                '}';
    }
}
