package com.kastech.blumen.model.superadmin;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "security_questions" ,schema = "blumen2")
public class SecurityQuestions {

    @Id
    private Long id;

    @Column
    @Nullable
    private Long orgId;

    @Column
    @Nullable
    private String orgCode;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<SecurityQuestionsList> securityQuestionsListList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(@Nullable Long orgId) {
        this.orgId = orgId;
    }

    @Nullable
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(@Nullable String orgCode) {
        this.orgCode = orgCode;
    }

    public List<SecurityQuestionsList> getSecurityQuestionsListList() {
        return securityQuestionsListList;
    }

    public void setSecurityQuestionsListList(List<SecurityQuestionsList> securityQuestionsListList) {
        this.securityQuestionsListList = securityQuestionsListList;
    }

    public SecurityQuestions(Long id, @Nullable Long orgId, @Nullable String orgCode, List<SecurityQuestionsList> securityQuestionsListList) {
        this.id = id;
        this.orgId = orgId;
        this.orgCode = orgCode;
        this.securityQuestionsListList = securityQuestionsListList;
    }

    @Override
    public String toString() {
        return "SecurityQuestions{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", orgCode='" + orgCode + '\'' +
                ", securityQuestionsListList=" + securityQuestionsListList +
                '}';
    }
}

