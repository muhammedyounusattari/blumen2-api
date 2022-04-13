package com.kastech.blumen.model.customize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grading_group_list" ,schema = "blumen2")
public class GradingGroupList {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grading_grp_list_seq_gen")
    @SequenceGenerator(name="grading_grp_list_seq_gen", sequenceName="GRADING_GROUP_LIST_SEQ")
    private long gradeGroupId;
    private String gradeGroupName;
    private String gradeGroupGradeType;
    private String gradeGroupAprColumn;

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

    public GradingGroupList() {
    }

    public GradingGroupList(long gradeGroupId, String gradeGroupName, String gradeGroupGradeType, String gradeGroupAprColumn
                             ,Date createdDate,long createdBy,Date modifiedDate,long modifiedBy,Date deletedDate,long deletedBy,long orgId, long id, long tempId) {
        this.gradeGroupId = gradeGroupId;
        this.gradeGroupName = gradeGroupName;
        this.gradeGroupGradeType = gradeGroupGradeType;
        this.gradeGroupAprColumn = gradeGroupAprColumn;
        this.createdDate=createdDate;
        this.createdBy=createdBy;
        this.modifiedDate=modifiedDate;
        this.deletedDate=deletedDate;
        this.modifiedBy=modifiedBy;
        this.deletedBy=deletedBy;
        this.orgId=orgId;
        this.id = id;
    }

    public long getGradeGroupId() {
        return gradeGroupId;
    }

    public void setGradeGroupId(long gradeGroupId) {
        this.gradeGroupId = gradeGroupId;
    }

    public String getGradeGroupName() {
        return gradeGroupName;
    }

    public void setGradeGroupName(String gradeGroupName) {
        this.gradeGroupName = gradeGroupName;
    }

    public String getGradeGroupGradeType() {
        return gradeGroupGradeType;
    }

    public void setGradeGroupGradeType(String gradeGroupGradeType) {
        this.gradeGroupGradeType = gradeGroupGradeType;
    }

    public String getGradeGroupAprColumn() {
        return gradeGroupAprColumn;
    }

    public void setGradeGroupAprColumn(String gradeGroupAprColumn) {
        this.gradeGroupAprColumn = gradeGroupAprColumn;
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
        return "GradingGroupList{" +
                "gradeGroupId='" + gradeGroupId + '\'' +
                ", gradeGroupName='" + gradeGroupName + '\'' +
                ", gradeGroupGradeType='" + gradeGroupGradeType + '\'' +
                ", gradeGroupAprColumn='" + gradeGroupAprColumn + '\'' +
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

    public GradingGroupList updateWith(GradingGroupList item) {
        return new GradingGroupList(
                this.gradeGroupId,
                item.gradeGroupName,
                item.gradeGroupGradeType,
                item.gradeGroupAprColumn,
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
