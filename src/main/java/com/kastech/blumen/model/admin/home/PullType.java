package com.kastech.blumen.model.admin.home;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Pulltype" ,schema = "blumen2")

public class PullType {
    @Id
    private Long pullTypeId;
    @Column(nullable = false,length = 100 )
    @NotNull
    private String pullDesc;
    @Column(nullable = false,length = 30 )
    @NotNull
    private String pullType;
    @Column(nullable = false)

    private Boolean isNumeric;
    @Column(nullable = false)
    @NotNull
    private Boolean apr;
    @Column(nullable = false)
    @NotNull
    private Boolean noEdit;
    @Column(nullable = true,length = 300  )
    private String dataFields;
    @Column(nullable = false  )
    @NotNull
    private Long serType;
    @Column(name = "projType",nullable=false)
    @NotNull
    private Long projType;
    @Column(nullable = true  )
    private String sortOrder;
    @Column(nullable = true,length = 500   )
    private String quickEditDesc;
    @Column(nullable = false  )
    @NotNull
    private Boolean isPrimary;



    public Long getPullTypeId() {
        return pullTypeId;
    }

    public void setPullTypeId(Long pullTypeId) {
        this.pullTypeId = pullTypeId;
    }

    public String getPullDesc() {
        return pullDesc;
    }

    public void setPullDesc(String pullDesc) {
        this.pullDesc = pullDesc;
    }

    public String getPullType() {
        return pullType;
    }

    public void setPullType(String pullType) {
        this.pullType = pullType;
    }



    public Boolean getApr() {
        return apr;
    }

    public void setApr(Boolean apr) {
        this.apr = apr;
    }

    public Boolean getNoEdit() {
        return noEdit;
    }

    public void setNoEdit(Boolean noEdit) {
        this.noEdit = noEdit;
    }

    public String getDataFields() {
        return dataFields;
    }

    public void setDataFields(String dataFields) {
        this.dataFields = dataFields;
    }

    public Long getSerType() {
        return serType;
    }

    public void setSerType(Long serType) {
        this.serType = serType;
    }

    public Long getProjType() {
        return projType;
    }

    public void setProjType(Long projType) {
        this.projType = projType;
    }

    public String getQuickEditDesc() {
        return quickEditDesc;
    }

    public void setQuickEditDesc(String quickEditDesc) {
        this.quickEditDesc = quickEditDesc;
    }

    public Boolean getNumeric() {
        return isNumeric;
    }

    public void setNumeric(Boolean numeric) {
        isNumeric = numeric;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "PullType{" +
                "pullTypeId=" + pullTypeId +
                ", pullDesc='" + pullDesc + '\'' +
                ", pullType='" + pullType + '\'' +
                ", isNumeric=" + isNumeric +
                ", apr=" + apr +
                ", noEdit=" + noEdit +
                ", dataFields='" + dataFields + '\'' +
                ", serType=" + serType +
                ", projType=" + projType +
                ", sortOrder='" + sortOrder + '\'' +
                ", quickEditDesc='" + quickEditDesc + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
