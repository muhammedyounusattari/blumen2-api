package com.kastech.blumen.model;

public class GradingList {

    private String gradingId;
    private boolean graduateList;
    private String gradingName;
    private String gradingGroupName;
    private String gradingNewGrade;
    private String gradingParticipantStatus;
    private String gradingYearEnbStatus;

    public GradingList() {
    }

    public GradingList(String gradingId, boolean graduateList, String gradingName, String gradingGroupName, String gradingNewGrade, String gradingParticipantStatus, String gradingYearEnbStatus) {
        this.gradingId = gradingId;
        this.graduateList = graduateList;
        this.gradingName = gradingName;
        this.gradingGroupName = gradingGroupName;
        this.gradingNewGrade = gradingNewGrade;
        this.gradingParticipantStatus = gradingParticipantStatus;
        this.gradingYearEnbStatus = gradingYearEnbStatus;
    }

    public String getGradingId() {
        return gradingId;
    }

    public void setGradingId(String gradingId) {
        this.gradingId = gradingId;
    }

    public boolean isGraduateList() {
        return graduateList;
    }

    public void setGraduateList(boolean graduateList) {
        this.graduateList = graduateList;
    }

    public String getGradingName() {
        return gradingName;
    }

    public void setGradingName(String gradingName) {
        this.gradingName = gradingName;
    }

    public String getGradingGroupName() {
        return gradingGroupName;
    }

    public void setGradingGroupName(String gradingGroupName) {
        this.gradingGroupName = gradingGroupName;
    }

    public String getGradingNewGrade() {
        return gradingNewGrade;
    }

    public void setGradingNewGrade(String gradingNewGrade) {
        this.gradingNewGrade = gradingNewGrade;
    }

    public String getGradingParticipantStatus() {
        return gradingParticipantStatus;
    }

    public void setGradingParticipantStatus(String gradingParticipantStatus) {
        this.gradingParticipantStatus = gradingParticipantStatus;
    }

    public String getGradingYearEnbStatus() {
        return gradingYearEnbStatus;
    }

    public void setGradingYearEnbStatus(String gradingYearEnbStatus) {
        this.gradingYearEnbStatus = gradingYearEnbStatus;
    }

    @Override
    public String toString() {
        return "GradingList{" +
                "gradingId='" + gradingId + '\'' +
                ", graduateList=" + graduateList +
                ", gradingName='" + gradingName + '\'' +
                ", gradingGroupName='" + gradingGroupName + '\'' +
                ", gradingNewGrade='" + gradingNewGrade + '\'' +
                ", gradingParticipantStatus='" + gradingParticipantStatus + '\'' +
                ", gradingYearEnbStatus='" + gradingYearEnbStatus + '\'' +
                '}';
    }
}
