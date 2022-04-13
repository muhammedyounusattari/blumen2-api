package com.kastech.blumen.model.customize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grading_list" ,schema = "blumen2")
public class GradingList {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="grading_list_seq_gen")
    @SequenceGenerator(name="grading_list_seq_gen", sequenceName="GRADING_LIST_SEQ")
    private long gradingId;
    private boolean graduateList;
    private String gradingName;
    private String gradingGroupName;
    private String gradingNewGrade;
    private String gradingParticipantStatus;
    private String gradingYearEnbStatus;

    private String gradingFiscalYear;
    private Date createdDate;
    private long createdBy;
    private Date modifiedDate;
    private long modifiedBy;
    private Date deletedDate;
    private long deletedBy;
    private long orgId;
    private long id;

    @Transient
    private long tempId;

    public GradingList() {
    }

    public GradingList(long gradingId, boolean graduateList, String gradingName, String gradingGroupName, String gradingNewGrade, String gradingParticipantStatus, String gradingYearEnbStatus, String gradingFiscalYear
            ,Date createdDate,long createdBy,Date modifiedDate,long modifiedBy,Date deletedDate,long deletedBy,long orgId, long id, long tempId) {
        this.gradingId = gradingId;
        this.graduateList = graduateList;
        this.gradingName = gradingName;
        this.gradingGroupName = gradingGroupName;
        this.gradingNewGrade = gradingNewGrade;
        this.gradingParticipantStatus = gradingParticipantStatus;
        this.gradingYearEnbStatus = gradingYearEnbStatus;
        this.gradingFiscalYear = gradingFiscalYear;
        this.createdDate=createdDate;
        this.createdBy=createdBy;
        this.modifiedDate=modifiedDate;
        this.deletedDate=deletedDate;
        this.modifiedBy=modifiedBy;
        this.deletedBy=deletedBy;
        this.orgId=orgId;
        this.id = id;
        this.tempId = tempId;


    }

    public long getGradingId() {
        return gradingId;
    }

    public void setGradingId(long gradingId) {
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

    public String getGradingFiscalYear() {
        return gradingFiscalYear;
    }

    public void setGradingFiscalYear(String gradingFiscalYear) {
        this.gradingFiscalYear = gradingFiscalYear;
    }

    public Date getCreatedDate() {return createdDate;}

    public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}

    public long getCreatedBy() {return createdBy;}

    public void setCreatedBy(long createdBy) {this.createdBy = createdBy;}

    public Date getModifiedDate() {return modifiedDate;}

    public void setModifiedDate(Date modifiedDate) {this.modifiedDate = modifiedDate;}

    public long getModifiedBy() {return modifiedBy;}

    public void setModifiedBy(long modifiedBy) {this.modifiedBy = modifiedBy;}

    public Date getDeletedDate() {return deletedDate;}

    public void setDeletedDate(Date deletedDate) {this.deletedDate = deletedDate;}

    public long getDeletedBy() {return deletedBy;}

    public void setDeletedBy(long deletedBy) {this.deletedBy = deletedBy;}

    public long getOrgId() {return orgId;}

    public void setOrgId(long orgId) {this.orgId = orgId;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getTempId() {return tempId;}

    public void setTempId(long tempId) {this.tempId = tempId;}

    @Override
    public String toString() {
        return "GradingList{" +
                "gradingId=" + gradingId +
                ", graduateList=" + graduateList +
                ", gradingName='" + gradingName + '\'' +
                ", gradingGroupName='" + gradingGroupName + '\'' +
                ", gradingNewGrade='" + gradingNewGrade + '\'' +
                ", gradingParticipantStatus='" + gradingParticipantStatus + '\'' +
                ", gradingYearEnbStatus='" + gradingYearEnbStatus + '\'' +
                ", gradingFiscalYear='" + gradingFiscalYear + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", deletedDate='" + deletedDate + '\'' +
                ", deletedBy='" + deletedBy + '\'' +
                ", orgId='" + orgId + '\'' +
                ", id='" + id + '\'' +
                ", tempId='" + tempId + '\'' +
                '}';
    }

    public GradingList updateWith(GradingList item) {
        return new GradingList(
                this.gradingId,
                item.graduateList,
                item.gradingName,
                item.gradingGroupName,
                item.gradingNewGrade,
                item.gradingParticipantStatus,
                item.gradingYearEnbStatus,
                item.gradingFiscalYear,
                item.createdDate,
                item.createdBy,
                item.modifiedDate,
                item.modifiedBy,
                item.deletedDate,
                item.deletedBy,
                item.orgId,
                item.id,
                item.tempId
        );
    }
}
