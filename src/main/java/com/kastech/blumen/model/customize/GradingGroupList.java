package com.kastech.blumen.model.customize;

public class GradingGroupList {

    private String gradeGroupId;
    private String gradeGroupName;
    private String gradeGroupGradeType;
    private String gradeGroupAprColumn;

    public GradingGroupList() {
    }

    public GradingGroupList(String gradeGroupId, String gradeGroupName, String gradeGroupGradeType, String gradeGroupAprColumn) {
        this.gradeGroupId = gradeGroupId;
        this.gradeGroupName = gradeGroupName;
        this.gradeGroupGradeType = gradeGroupGradeType;
        this.gradeGroupAprColumn = gradeGroupAprColumn;
    }

    public String getGradeGroupId() {
        return gradeGroupId;
    }

    public void setGradeGroupId(String gradeGroupId) {
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
}
