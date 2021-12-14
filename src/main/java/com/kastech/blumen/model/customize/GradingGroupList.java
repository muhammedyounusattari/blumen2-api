package com.kastech.blumen.model.customize;

import javax.persistence.*;

@Entity
@Table(name = "grading_group_list" ,schema = "blumen2")
public class GradingGroupList {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="grading_grp_list_seq_gen")
    @SequenceGenerator(name="grading_grp_list_seq_gen", sequenceName="GRADING_GROUP_LIST_SEQ")
    private Long gradeGroupId;
    private String gradeGroupName;
    private String gradeGroupGradeType;
    private String gradeGroupAprColumn;

    public GradingGroupList() {
    }

    public GradingGroupList(Long gradeGroupId, String gradeGroupName, String gradeGroupGradeType, String gradeGroupAprColumn) {
        this.gradeGroupId = gradeGroupId;
        this.gradeGroupName = gradeGroupName;
        this.gradeGroupGradeType = gradeGroupGradeType;
        this.gradeGroupAprColumn = gradeGroupAprColumn;
    }

    public Long getGradeGroupId() {
        return gradeGroupId;
    }

    public void setGradeGroupId(Long gradeGroupId) {
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

    @Override
    public String toString() {
        return "GradingGroupList{" +
                "gradeGroupId='" + gradeGroupId + '\'' +
                ", gradeGroupName='" + gradeGroupName + '\'' +
                ", gradeGroupGradeType='" + gradeGroupGradeType + '\'' +
                ", gradeGroupAprColumn='" + gradeGroupAprColumn + '\'' +
                '}';
    }

    public GradingGroupList updateWith(GradingGroupList item) {
        return new GradingGroupList(
                this.gradeGroupId,
                item.gradeGroupName,
                item.gradeGroupGradeType,
                item.gradeGroupAprColumn
        );
    }
}
