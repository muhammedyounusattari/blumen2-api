package com.kastech.blumen.model.keycloak;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bolt", schema = "blumen2")
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class BOLT implements Serializable {

    @Id
    private Long id;

    @Nullable
    private String link;

    @Nullable
    private Date startDate;

    @Nullable
    private Date endDate;
    private Boolean active;

    @Column(length = 2000)
    private String lastGenerated;

    public BOLT() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public String getLink() {
        return link;
    }

    public void setLink(@Nullable String link) {
        this.link = link;
    }

    @Nullable
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@Nullable Date startDate) {
        this.startDate = startDate;
    }

    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLastGenerated() {
        return lastGenerated;
    }

    public void setLastGenerated(String lastGenerated) {
        this.lastGenerated = lastGenerated;
    }

    public BOLT(Long id, @Nullable String link, @Nullable Date startDate, @Nullable Date endDate, Boolean active, String lastGenerated) {
        this.id = id;
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.lastGenerated = lastGenerated;
    }

    @Override
    public String toString() {
        return "BOLT{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", active=" + active +
                ", lastGenerated='" + lastGenerated + '\'' +
                '}';
    }
}
