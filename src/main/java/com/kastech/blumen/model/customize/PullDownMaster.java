package com.kastech.blumen.model.customize;



import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pullDownMaster" ,schema = "blumen2")
public class PullDownMaster {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pullid", nullable = false)
    private Long pullId;
    @Column(nullable = false,length = 50 )
    private String pullname;
    @Column(nullable = false,length = 50 )
    private String pulltype;
    @Column(nullable = false,length = 50 )
    private Boolean inoriginal;
    private Boolean isNumeric;
    @Column(nullable = false,length = 4000 )

    private String longpullna;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date  lastmodify;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date  timestamp_column;
    private Long organizationid;
    private Long projtype;
    private Boolean deleted;
    @Column(nullable = false,length = 50 )
    private String lastuser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPullname() {
        return pullname;
    }

    public void setPullname(String pullname) {
        this.pullname = pullname;
    }

    public String getPulltype() {
        return pulltype;
    }

    public void setPulltype(String pulltype) {
        this.pulltype = pulltype;
    }

    public Boolean getInoriginal() {
        return inoriginal;
    }

    public void setInoriginal(Boolean inoriginal) {
        this.inoriginal = inoriginal;
    }

    public Boolean getNumeric() {
        return isNumeric;
    }

    public void setNumeric(Boolean numeric) {
        isNumeric = numeric;
    }

    public String getLongpullna() {
        return longpullna;
    }

    public void setLongpullna(String longpullna) {
        this.longpullna = longpullna;
    }

    public Date getTimestamp_column() {
        return timestamp_column;
    }

    public void setTimestamp_column(Date timestamp_column) {
        this.timestamp_column = timestamp_column;
    }

    public Long getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Long organizationid) {
        this.organizationid = organizationid;
    }

    public Long getProjtype() {
        return projtype;
    }

    public void setProjtype(Long projtype) {
        this.projtype = projtype;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getPullId() {
        return pullId;
    }

    public void setPullId(Long pullId) {
        this.pullId = pullId;
    }

    public Date getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(Date lastmodify) {
        this.lastmodify = lastmodify;
    }

    public String getLastuser() {
        return lastuser;
    }

    public void setLastuser(String lastuser) {
        this.lastuser = lastuser;
    }
}
