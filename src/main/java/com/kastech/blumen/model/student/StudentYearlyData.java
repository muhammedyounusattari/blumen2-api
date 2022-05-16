package com.kastech.blumen.model.student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "student_yearly", schema = "blumen2")
public class StudentYearlyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "stuid", length = 8, nullable = false, precision = 19)
    private BigInteger stuid;

    @NotNull
    @Column(name = "yearfi", length = 4, nullable = false, precision = 10)
    private Integer yearFi;

    @NotNull
    @Column(name = "active", length = 1, nullable = false)
    private Boolean active;

    @NotNull
    @Column(name = "served", length = 1, nullable = false)
    private Boolean served;

    @NotNull
    @Column(name = "reported", length = 1, nullable = false)
    private Boolean reported;

    @Column(name = "counsel", length = 50)
    private String counsel;

    @Column(name = "advisor", length = 50)
    private String advisor;

    @Column(name = "tutor", length = 50)
    private String tutor;

    @Column(name = "custom3", length = 50)
    private String custom3;

    @Column(name = "custom4", length = 50)
    private String custom4;

    @Column(name = "school", length = 500)
    private String school;

    @Column(name = "standing", length = 4, precision = 10)
    private Integer standing;

    @Column(name = "college", length = 500)
    private String college;

    @Column(name = "collegety", length = 4, precision = 10)
    private Integer collegeTy;

    @Column(name = "major", length = 50)
    private String major;

    @Column(name = "gpastartsc", length = 4, precision = 10)
    private Integer gpastartsc;

    @Column(name = "gpaendsc", length = 4, precision = 10)
    private Integer gpaendsc;

    @Column(name = "gpastart", length = 8, precision = 53)
    private Float gpastart;

    @Column(name = "gpaend", length = 8, precision = 53)
    private Float gpaend;

    @Column(name = "partstatus", length = 4, precision = 10)
    private Integer partStatus;

    @Column(name = "rentrydate", length = 8)
    private Timestamp rentryDate;

    @Column(name = "initiative", length = 4, precision = 10)
    private Integer initiative;

    @Column(name = "reasonleav", length = 4, precision = 10)
    private Integer reasonLeav;

    @Column(name = "partlevel", length = 4, precision = 10)
    private Integer partLevel;

    @Column(name = "testtype", length = 4, precision = 10)
    private Integer testType;

    @Column(name = "psatscore", length = 4, precision = 10)
    private Integer psatScore;

    @Column(name = "actPlan", length = 4, precision = 10)
    private Integer actplan;

    @Column(name = "gradelevel", length = 4, precision = 10)
    private Integer gradeLevel;

    @Column(name = "recruit", length = 4, precision = 10)
    private Integer recruit;

    @Column(name = "selftran", length = 4, precision = 10)
    private Integer selfTran;

    @Column(name = "enroll", length = 4, precision = 10)
    private Integer enroll;

    @Column(name = "collgradel", length = 4, precision = 10)
    private Integer collgradel;

    @Column(name = "acadstand", length = 4, precision = 10)
    private Integer acadstand;

    @Column(name = "partlength", length = 4, precision = 10)
    private Integer partLength;

    @Column(name = "vgradelev", length = 4, precision = 10)
    private Integer vgradelev;

    @Column(name = "collyear", length = 4, precision = 10)
    private Integer collyear;

    @Column(name = "bridge", length = 4, precision = 10)
    private Boolean bridge;

    @Column(name = "colldate", length = 8)
    private Timestamp colldate;

    @Column(name = "finaidreq", length = 1)
    private Boolean finaidreq;

    @Column(name = "finaidreqa", length = 8, precision = 19, scale = 4)
    private Double finaidreqa;

    @Column(name = "finaidrec", length = 1)
    private Boolean finaidrec;

    @Column(name = "finaidreca", length = 8, precision = 19, scale = 4)
    private Double finaidreca;

    @Column(name = "finaidname", length = 50)
    private String finaidName;

    @Column(name = "finaidunme", length = 50)
    private String finaidunme;

    @Column(name = "finaidreas", length = 4, precision = 10)
    private Integer finaidreas;

    @Column(name = "graaidreq", length = 1)
    private Boolean graaidreq;

    @Column(name = "graaidreqa", length = 8, precision = 19, scale = 4)
    private Double graaidreqa;

    @Column(name = "graaidrec", length = 1)
    private Boolean graaidrec;

    @Column(name = "graaidreca", length = 8, precision = 19, scale = 4)
    private Double graaidreca;

    @Column(name = "endstatus", length = 4, precision = 10)
    private Integer endStatus;

    @Column(name = "age", length = 4, precision = 10)
    private Integer age;

    @Column(name = "lastcont", length = 8)
    private Timestamp lastcont;

    @Column(name = "lastmodify", length = 8)
    private Timestamp lastModify;

    @Column(name = "lastuser", length = 50)
    private String lastUser;

    @Column(name = "hscred", length = 8, precision = 53)
    private Integer hscred;

    @Column(name = "psecred", length = 8, precision = 53)
    private Integer psecred;

    @Column(name = "bridcred", length = 8, precision = 53)
    private Integer bridcred;

    @Column(name = "bridnocred", length = 8, precision = 53)
    private Integer bridnocred;

    @Column(name = "pseterm", length = 4, precision = 10)
    private Integer pseterm;

    @Column(name = "collready", length = 4, precision = 10)
    private Integer collReady;

    @Column(name = "gradestart", length = 4, precision = 10)
    private Integer gradeStart;

    @Column(name = "hsgradepro", length = 4, precision = 10)
    private Integer hsgradepro;

    @Column(name = "hsgradstat", length = 4, precision = 10)
    private Integer hsgradstat;

    @Column(name = "vcall", length = 4, precision = 10)
    private Integer vcall;

    @Column(name = "vcalldate", length = 8)
    private Timestamp vcallDate;

    @Column(name = "vcalldater", length = 8)
    private Timestamp vcallDater;

    @Column(name = "notes", length = 16)
    private String notes;

    @Column(name = "recupdated", length = 4, precision = 10)
    private Integer recupdated;

    @Column(name = "noenreason", length = 4, precision = 10)
    private Integer noenreason;

    @Column(name = "mcnmajor", length = 4, precision = 10)
    private Integer mcnmajor;

    @Column(name = "trackcomp", length = 4, precision = 10)
    private Integer trackComp;

    @Column(name = "specialcir", length = 16)
    private String specialcir;

    @Column(name = "fundsource", length = 4, precision = 10)
    private Integer fundSource;

    @Column(name = "persistend", length = 4, precision = 10)
    private Integer persistend;

    @Column(name = "persiststa", length = 4, precision = 10)
    private Integer persiststa;

    @Column(name = "transfers", length = 4, precision = 10)
    private Integer transfers;

    @Column(name = "degree", length = 4, precision = 10)
    private Integer degree;

    @Column(name = "degreedate", length = 50)
    private String degreeDate;

    @Column(name = "sumbridge", length = 4, precision = 10)
    private Integer sumBridge;

    @Column(name = "projretain", length = 4, precision = 10)
    private Integer projretain;

    @Column(name = "enrollobj", length = 4, precision = 10)
    private Integer enrollObj;

    @Column(name = "persistden", length = 4, precision = 10)
    private Integer persistDen;

    @Column(name = "persistnum", length = 4, precision = 10)
    private Integer persistNum;

    @Column(name = "state10rla", length = 4, precision = 10)
    private Integer state10rla;

    @Column(name = "state10mat", length = 4, precision = 10)
    private Integer state10mat;

    @Column(name = "vettest", length = 4, precision = 10)
    private Integer vetTest;

    @Column(name = "mcresearch", length = 4, precision = 10)
    private Integer mcreSearch;

    @Column(name = "mcintern", length = 4, precision = 10)
    private Integer mcIntern;

    @Column(name = "timestamp_column", length = 8)
    private Timestamp timestampColumn;

    @Column(name = "organizationid", length = 4, precision = 10)
    private Integer organizationId;

    @NotNull
    @Column(name = "deleted", length = 1, nullable = false)
    private Boolean deleted;

    @Column(name = "DUALENROLL", length = 4, precision = 10)
    private Integer dualEnroll;

    @Column(name = "RIGOROUS", length = 4, precision = 10)
    private Integer rigorous;

    @Column(name = "OTHERTRIO", length = 4, precision = 10)
    private Integer otherTrio;

    @Column(name = "FAFSA", length = 4, precision = 10)
    private Integer FAFSA;

    @Column(name = "DECEASED", length = 4, precision = 10)
    private Integer DECEASED;

    @Column(name = "GPAUNWEIGH", length = 8, precision = 53)
    private Float gpaunweigh;

    @Column(name = "SCHPERSIST", length = 4, precision = 10)
    private Integer schPersist;

    @Column(name = "APCOURSE", length = 4, precision = 10)
    private Integer apCourse;

    @Column(name = "DECREDENTI", length = 4, precision = 10)
    private Integer decredenti;

    @Column(name = "ADVANCEMAT", length = 4, precision = 10)
    private Integer advancemat;

    @Column(name = "EMPLOY", length = 4, precision = 10)
    private Integer employ;

    @Column(name = "CERTI", length = 4, precision = 10)
    private Integer certi;

    @Column(name = "CERTIDT", length = 40)
    private String certidt;

    @Column(name = "ADEGREE", length = 4, precision = 10)
    private Integer aDegree;

    @Column(name = "ADEGREEDT", length = 40)
    private String adegreedt;

    @Column(name = "BDEGREE", length = 4, precision = 10)
    private Integer bDegree;

    @Column(name = "BDEGREEDT", length = 40)
    private Date bdegreedt;

    @Column(name = "PSENROLL", length = 4, precision = 10)
    private Integer psEnroll;

    @Column(name = "PSREMEDIAT", length = 4, precision = 10)
    private Integer psremediat;

    @Column(name = "PSCOMPLETE", length = 4, precision = 10)
    private Integer psComplete;

    @Column(name = "STEMDEGREE", length = 4, precision = 10)
    private Integer stemDegree;

    @Column(name = "NAMECHANGE", length = 8000)
    private String nameChange;

    @Column(name = "MCSCHOLAR", length = 4, precision = 10)
    private Integer mcScholar;

    @Column(name = "GPERSIST", length = 4, precision = 10)
    private Integer gPersist;

    @Column(name = "GRADSTUDYL", length = 4, precision = 10)
    private Integer gradStudyl;

    @Column(name = "GRADSTUDY", length = 200)
    private String gradStudy;

    @Column(name = "GRADASSIST", length = 4, precision = 10)
    private Integer gradAssist;

    @Column(name = "GREASON", length = 4, precision = 10)
    private Integer greason;

    @Column(name = "completeyr", length = 4, precision = 10)
    private Integer completeyr;

    @Column(name = "vcalllen", length = 4, precision = 10)
    private Integer vcalllen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getStuid() {
        return stuid;
    }

    public void setStuid(BigInteger stuid) {
        this.stuid = stuid;
    }

    public Integer getYearFi() {
        return yearFi;
    }

    public void setYearFi(Integer yearFi) {
        this.yearFi = yearFi;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getServed() {
        return served;
    }

    public void setServed(Boolean served) {
        this.served = served;
    }

    public Boolean getReported() {
        return reported;
    }

    public void setReported(Boolean reported) {
        this.reported = reported;
    }

    public String getCounsel() {
        return counsel;
    }

    public void setCounsel(String counsel) {
        this.counsel = counsel;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getStanding() {
        return standing;
    }

    public void setStanding(Integer standing) {
        this.standing = standing;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getCollegeTy() {
        return collegeTy;
    }

    public void setCollegeTy(Integer collegeTy) {
        this.collegeTy = collegeTy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getGpastartsc() {
        return gpastartsc;
    }

    public void setGpastartsc(Integer gpastartsc) {
        this.gpastartsc = gpastartsc;
    }

    public Integer getGpaendsc() {
        return gpaendsc;
    }

    public void setGpaendsc(Integer gpaendsc) {
        this.gpaendsc = gpaendsc;
    }

    public Float getGpastart() {
        return gpastart;
    }

    public void setGpastart(Float gpastart) {
        this.gpastart = gpastart;
    }

    public Float getGpaend() {
        return gpaend;
    }

    public void setGpaend(Float gpaend) {
        this.gpaend = gpaend;
    }

    public Integer getPartStatus() {
        return partStatus;
    }

    public void setPartStatus(Integer partStatus) {
        this.partStatus = partStatus;
    }

    public Timestamp getRentryDate() {
        return rentryDate;
    }

    public void setRentryDate(Timestamp rentryDate) {
        this.rentryDate = rentryDate;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getReasonLeav() {
        return reasonLeav;
    }

    public void setReasonLeav(Integer reasonLeav) {
        this.reasonLeav = reasonLeav;
    }

    public Integer getPartLevel() {
        return partLevel;
    }

    public void setPartLevel(Integer partLevel) {
        this.partLevel = partLevel;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getPsatScore() {
        return psatScore;
    }

    public void setPsatScore(Integer psatScore) {
        this.psatScore = psatScore;
    }

    public Integer getActplan() {
        return actplan;
    }

    public void setActplan(Integer actplan) {
        this.actplan = actplan;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Integer getRecruit() {
        return recruit;
    }

    public void setRecruit(Integer recruit) {
        this.recruit = recruit;
    }

    public Integer getSelfTran() {
        return selfTran;
    }

    public void setSelfTran(Integer selfTran) {
        this.selfTran = selfTran;
    }

    public Integer getEnroll() {
        return enroll;
    }

    public void setEnroll(Integer enroll) {
        this.enroll = enroll;
    }

    public Integer getCollgradel() {
        return collgradel;
    }

    public void setCollgradel(Integer collgradel) {
        this.collgradel = collgradel;
    }

    public Integer getAcadstand() {
        return acadstand;
    }

    public void setAcadstand(Integer acadstand) {
        this.acadstand = acadstand;
    }

    public Integer getPartLength() {
        return partLength;
    }

    public void setPartLength(Integer partLength) {
        this.partLength = partLength;
    }

    public Integer getVgradelev() {
        return vgradelev;
    }

    public void setVgradelev(Integer vgradelev) {
        this.vgradelev = vgradelev;
    }

    public Integer getCollyear() {
        return collyear;
    }

    public void setCollyear(Integer collyear) {
        this.collyear = collyear;
    }

    public Boolean getBridge() {
        return bridge;
    }

    public void setBridge(Boolean bridge) {
        this.bridge = bridge;
    }

    public Timestamp getColldate() {
        return colldate;
    }

    public void setColldate(Timestamp colldate) {
        this.colldate = colldate;
    }

    public Boolean getFinaidreq() {
        return finaidreq;
    }

    public void setFinaidreq(Boolean finaidreq) {
        this.finaidreq = finaidreq;
    }

    public Double getFinaidreqa() {
        return finaidreqa;
    }

    public void setFinaidreqa(Double finaidreqa) {
        this.finaidreqa = finaidreqa;
    }

    public Boolean getFinaidrec() {
        return finaidrec;
    }

    public void setFinaidrec(Boolean finaidrec) {
        this.finaidrec = finaidrec;
    }

    public Double getFinaidreca() {
        return finaidreca;
    }

    public void setFinaidreca(Double finaidreca) {
        this.finaidreca = finaidreca;
    }

    public String getFinaidName() {
        return finaidName;
    }

    public void setFinaidName(String finaidName) {
        this.finaidName = finaidName;
    }

    public String getFinaidunme() {
        return finaidunme;
    }

    public void setFinaidunme(String finaidunme) {
        this.finaidunme = finaidunme;
    }

    public Integer getFinaidreas() {
        return finaidreas;
    }

    public void setFinaidreas(Integer finaidreas) {
        this.finaidreas = finaidreas;
    }

    public Boolean getGraaidreq() {
        return graaidreq;
    }

    public void setGraaidreq(Boolean graaidreq) {
        this.graaidreq = graaidreq;
    }

    public Double getGraaidreqa() {
        return graaidreqa;
    }

    public void setGraaidreqa(Double graaidreqa) {
        this.graaidreqa = graaidreqa;
    }

    public Boolean getGraaidrec() {
        return graaidrec;
    }

    public void setGraaidrec(Boolean graaidrec) {
        this.graaidrec = graaidrec;
    }

    public Double getGraaidreca() {
        return graaidreca;
    }

    public void setGraaidreca(Double graaidreca) {
        this.graaidreca = graaidreca;
    }

    public Integer getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(Integer endStatus) {
        this.endStatus = endStatus;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Timestamp getLastcont() {
        return lastcont;
    }

    public void setLastcont(Timestamp lastcont) {
        this.lastcont = lastcont;
    }

    public Timestamp getLastModify() {
        return lastModify;
    }

    public void setLastModify(Timestamp lastModify) {
        this.lastModify = lastModify;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public Integer getHscred() {
        return hscred;
    }

    public void setHscred(Integer hscred) {
        this.hscred = hscred;
    }

    public Integer getPsecred() {
        return psecred;
    }

    public void setPsecred(Integer psecred) {
        this.psecred = psecred;
    }

    public Integer getBridcred() {
        return bridcred;
    }

    public void setBridcred(Integer bridcred) {
        this.bridcred = bridcred;
    }

    public Integer getBridnocred() {
        return bridnocred;
    }

    public void setBridnocred(Integer bridnocred) {
        this.bridnocred = bridnocred;
    }

    public Integer getPseterm() {
        return pseterm;
    }

    public void setPseterm(Integer pseterm) {
        this.pseterm = pseterm;
    }

    public Integer getCollReady() {
        return collReady;
    }

    public void setCollReady(Integer collReady) {
        this.collReady = collReady;
    }

    public Integer getGradeStart() {
        return gradeStart;
    }

    public void setGradeStart(Integer gradeStart) {
        this.gradeStart = gradeStart;
    }

    public Integer getHsgradepro() {
        return hsgradepro;
    }

    public void setHsgradepro(Integer hsgradepro) {
        this.hsgradepro = hsgradepro;
    }

    public Integer getHsgradstat() {
        return hsgradstat;
    }

    public void setHsgradstat(Integer hsgradstat) {
        this.hsgradstat = hsgradstat;
    }

    public Integer getVcall() {
        return vcall;
    }

    public void setVcall(Integer vcall) {
        this.vcall = vcall;
    }

    public Timestamp getVcallDate() {
        return vcallDate;
    }

    public void setVcallDate(Timestamp vcallDate) {
        this.vcallDate = vcallDate;
    }

    public Timestamp getVcallDater() {
        return vcallDater;
    }

    public void setVcallDater(Timestamp vcallDater) {
        this.vcallDater = vcallDater;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getRecupdated() {
        return recupdated;
    }

    public void setRecupdated(Integer recupdated) {
        this.recupdated = recupdated;
    }

    public Integer getNoenreason() {
        return noenreason;
    }

    public void setNoenreason(Integer noenreason) {
        this.noenreason = noenreason;
    }

    public Integer getMcnmajor() {
        return mcnmajor;
    }

    public void setMcnmajor(Integer mcnmajor) {
        this.mcnmajor = mcnmajor;
    }

    public Integer getTrackComp() {
        return trackComp;
    }

    public void setTrackComp(Integer trackComp) {
        this.trackComp = trackComp;
    }

    public String getSpecialcir() {
        return specialcir;
    }

    public void setSpecialcir(String specialcir) {
        this.specialcir = specialcir;
    }

    public Integer getFundSource() {
        return fundSource;
    }

    public void setFundSource(Integer fundSource) {
        this.fundSource = fundSource;
    }

    public Integer getPersistend() {
        return persistend;
    }

    public void setPersistend(Integer persistend) {
        this.persistend = persistend;
    }

    public Integer getPersiststa() {
        return persiststa;
    }

    public void setPersiststa(Integer persiststa) {
        this.persiststa = persiststa;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getDegreeDate() {
        return degreeDate;
    }

    public void setDegreeDate(String degreeDate) {
        this.degreeDate = degreeDate;
    }

    public Integer getSumBridge() {
        return sumBridge;
    }

    public void setSumBridge(Integer sumBridge) {
        this.sumBridge = sumBridge;
    }

    public Integer getProjretain() {
        return projretain;
    }

    public void setProjretain(Integer projretain) {
        this.projretain = projretain;
    }

    public Integer getEnrollObj() {
        return enrollObj;
    }

    public void setEnrollObj(Integer enrollObj) {
        this.enrollObj = enrollObj;
    }

    public Integer getPersistDen() {
        return persistDen;
    }

    public void setPersistDen(Integer persistDen) {
        this.persistDen = persistDen;
    }

    public Integer getPersistNum() {
        return persistNum;
    }

    public void setPersistNum(Integer persistNum) {
        this.persistNum = persistNum;
    }

    public Integer getState10rla() {
        return state10rla;
    }

    public void setState10rla(Integer state10rla) {
        this.state10rla = state10rla;
    }

    public Integer getState10mat() {
        return state10mat;
    }

    public void setState10mat(Integer state10mat) {
        this.state10mat = state10mat;
    }

    public Integer getVetTest() {
        return vetTest;
    }

    public void setVetTest(Integer vetTest) {
        this.vetTest = vetTest;
    }

    public Integer getMcreSearch() {
        return mcreSearch;
    }

    public void setMcreSearch(Integer mcreSearch) {
        this.mcreSearch = mcreSearch;
    }

    public Integer getMcIntern() {
        return mcIntern;
    }

    public void setMcIntern(Integer mcIntern) {
        this.mcIntern = mcIntern;
    }

    public Timestamp getTimestampColumn() {
        return timestampColumn;
    }

    public void setTimestampColumn(Timestamp timestampColumn) {
        this.timestampColumn = timestampColumn;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getDualEnroll() {
        return dualEnroll;
    }

    public void setDualEnroll(Integer dualEnroll) {
        this.dualEnroll = dualEnroll;
    }

    public Integer getRigorous() {
        return rigorous;
    }

    public void setRigorous(Integer rigorous) {
        this.rigorous = rigorous;
    }

    public Integer getOtherTrio() {
        return otherTrio;
    }

    public void setOtherTrio(Integer otherTrio) {
        this.otherTrio = otherTrio;
    }

    public Integer getFAFSA() {
        return FAFSA;
    }

    public void setFAFSA(Integer FAFSA) {
        this.FAFSA = FAFSA;
    }

    public Integer getDECEASED() {
        return DECEASED;
    }

    public void setDECEASED(Integer DECEASED) {
        this.DECEASED = DECEASED;
    }

    public Float getGpaunweigh() {
        return gpaunweigh;
    }

    public void setGpaunweigh(Float gpaunweigh) {
        this.gpaunweigh = gpaunweigh;
    }

    public Integer getSchPersist() {
        return schPersist;
    }

    public void setSchPersist(Integer schPersist) {
        this.schPersist = schPersist;
    }

    public Integer getApCourse() {
        return apCourse;
    }

    public void setApCourse(Integer apCourse) {
        this.apCourse = apCourse;
    }

    public Integer getDecredenti() {
        return decredenti;
    }

    public void setDecredenti(Integer decredenti) {
        this.decredenti = decredenti;
    }

    public Integer getAdvancemat() {
        return advancemat;
    }

    public void setAdvancemat(Integer advancemat) {
        this.advancemat = advancemat;
    }

    public Integer getEmploy() {
        return employ;
    }

    public void setEmploy(Integer employ) {
        this.employ = employ;
    }

    public Integer getCerti() {
        return certi;
    }

    public void setCerti(Integer certi) {
        this.certi = certi;
    }

    public String getCertidt() {
        return certidt;
    }

    public void setCertidt(String certidt) {
        this.certidt = certidt;
    }

    public Integer getaDegree() {
        return aDegree;
    }

    public void setaDegree(Integer aDegree) {
        this.aDegree = aDegree;
    }

    public String getAdegreedt() {
        return adegreedt;
    }

    public void setAdegreedt(String adegreedt) {
        this.adegreedt = adegreedt;
    }

    public Integer getbDegree() {
        return bDegree;
    }

    public void setbDegree(Integer bDegree) {
        this.bDegree = bDegree;
    }

    public Date getBdegreedt() {
        return bdegreedt;
    }

    public void setBdegreedt(Date bdegreedt) {
        this.bdegreedt = bdegreedt;
    }

    public Integer getPsEnroll() {
        return psEnroll;
    }

    public void setPsEnroll(Integer psEnroll) {
        this.psEnroll = psEnroll;
    }

    public Integer getPsremediat() {
        return psremediat;
    }

    public void setPsremediat(Integer psremediat) {
        this.psremediat = psremediat;
    }

    public Integer getPsComplete() {
        return psComplete;
    }

    public void setPsComplete(Integer psComplete) {
        this.psComplete = psComplete;
    }

    public Integer getStemDegree() {
        return stemDegree;
    }

    public void setStemDegree(Integer stemDegree) {
        this.stemDegree = stemDegree;
    }

    public String getNameChange() {
        return nameChange;
    }

    public void setNameChange(String nameChange) {
        this.nameChange = nameChange;
    }

    public Integer getMcScholar() {
        return mcScholar;
    }

    public void setMcScholar(Integer mcScholar) {
        this.mcScholar = mcScholar;
    }

    public Integer getgPersist() {
        return gPersist;
    }

    public void setgPersist(Integer gPersist) {
        this.gPersist = gPersist;
    }

    public Integer getGradStudyl() {
        return gradStudyl;
    }

    public void setGradStudyl(Integer gradStudyl) {
        this.gradStudyl = gradStudyl;
    }

    public String getGradStudy() {
        return gradStudy;
    }

    public void setGradStudy(String gradStudy) {
        this.gradStudy = gradStudy;
    }

    public Integer getGradAssist() {
        return gradAssist;
    }

    public void setGradAssist(Integer gradAssist) {
        this.gradAssist = gradAssist;
    }

    public Integer getGreason() {
        return greason;
    }

    public void setGreason(Integer greason) {
        this.greason = greason;
    }

    public Integer getCompleteyr() {
        return completeyr;
    }

    public void setCompleteyr(Integer completeyr) {
        this.completeyr = completeyr;
    }

    public Integer getVcalllen() {
        return vcalllen;
    }

    public void setVcalllen(Integer vcalllen) {
        this.vcalllen = vcalllen;
    }
}
