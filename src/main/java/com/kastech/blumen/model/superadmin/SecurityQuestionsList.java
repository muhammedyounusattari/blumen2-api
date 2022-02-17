package com.kastech.blumen.model.superadmin;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security_question_list" ,schema = "blumen2")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityQuestionsList {

    @Id
    private Long id;

    @Column(length = 1000)
    private String name;

    @Column
    private String questionType;

    @Column
    private String orgCode;

    @Column
    private String orgId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public SecurityQuestionsList() {
    }

    public SecurityQuestionsList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SecurityQuestionsList(Long id, String name, String questionType, String orgCode, String orgId) {
        this.id = id;
        this.name = name;
        this.questionType = questionType;
        this.orgCode = orgCode;
        this.orgId = orgId;
    }
}
