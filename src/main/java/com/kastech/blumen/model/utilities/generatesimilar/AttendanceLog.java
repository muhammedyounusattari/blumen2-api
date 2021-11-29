package com.kastech.blumen.model.utilities.generatesimilar;

public class AttendanceLog {

    private String attendanceDate;
    private boolean attendanceChecked;
    private String attendanceAmount;
    private String attendanceNote;

    public AttendanceLog() {
    }

    public AttendanceLog(String attendanceDate, boolean attendanceChecked, String attendanceAmount, String attendanceNote) {
        this.attendanceDate = attendanceDate;
        this.attendanceChecked = attendanceChecked;
        this.attendanceAmount = attendanceAmount;
        this.attendanceNote = attendanceNote;
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
                "attendanceDate='" + attendanceDate + '\'' +
                ", attendanceChecked=" + attendanceChecked +
                ", attendanceAmount='" + attendanceAmount + '\'' +
                ", attendanceNote='" + attendanceNote + '\'' +
                '}';
    }
}
