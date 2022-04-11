package com.kastech.blumen.model.superadmin;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "security_question_list" ,schema = "blumen2")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityQuestionsList {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String name;

    @Column
    private String questionType;

    @Column
    private Long orgId;

   public SecurityQuestionsList(){

   }

    public SecurityQuestionsList(Long id, String name, String questionType, Long orgId) {
        this.id = id;
        this.name = name;
        this.questionType = questionType;
        this.orgId = orgId;
    }

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

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
