package com.kastech.blumen.model.customize;

import javax.persistence.*;

@Entity
@Table(name = "grading_list" ,schema = "blumen2")
public class GradingList {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="grading_list_seq_gen")
    @SequenceGenerator(name="grading_list_seq_gen", sequenceName="GRADING_LIST_SEQ")
    private Long gradingId;
    private boolean graduateList;
    private String gradingName;
    private String gradingGroupName;
    private String gradingNewGrade;
    private String gradingParticipantStatus;
    private String gradingYearEnbStatus;

    public GradingList() {
    }

    public GradingList(Long gradingId, boolean graduateList, String gradingName, String gradingGroupName, String gradingNewGrade, String gradingParticipantStatus, String gradingYearEnbStatus) {
        this.gradingId = gradingId;
        this.graduateList = graduateList;
        this.gradingName = gradingName;
        this.gradingGroupName = gradingGroupName;
        this.gradingNewGrade = gradingNewGrade;
        this.gradingParticipantStatus = gradingParticipantStatus;
        this.gradingYearEnbStatus = gradingYearEnbStatus;
    }

    public Long getGradingId() {
        return gradingId;
    }

    public void setGradingId(Long gradingId) {
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

    public GradingList updateWith(GradingList item) {
        return new GradingList(
                this.gradingId,
                item.graduateList,
                item.gradingGroupName,
                item.gradingNewGrade,
                item.gradingName,
                item.gradingParticipantStatus,
                item.gradingYearEnbStatus
        );
    }
}
