package com.kastech.blumen.model.student;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_yearly", schema = "blumen2")
public class StudentYearlyData {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_yearly_list_seq_gen")
    @SequenceGenerator(name="student_yearly_list_seq_gen", sequenceName="STUDENT_YEARLY_LIST_SEQ")
    private Long id;
    private Integer stuid;
    private Integer yearfi;
    private Integer active;
    private Integer served;
    private Integer reported;
    private String counsel;
    private String advisor;
    private String tutor;
    private String custom3;
    private String custom4;
    private String school;
    private Integer standing;
    private String college;
    private Integer collegety;
    private String major;
    private Integer gpastartsc;
    private Integer gpaendsc;
    private Integer gpastart;
    private Integer gpaend;
    private Integer partstatus;
    private Date rentrydate;
    private Integer initiative;
    private Integer reasonleav;
    private Integer partlevel;
    private Integer testtype;
    private Integer psatscore;
    private Integer actplan;
    private Integer gradelevel;
    private Integer recruit;
    private Integer selftran;
    private Integer enroll;
    private Integer collgradel;
    private Integer acadstand;
    private Integer partlength;
    private Integer vgradelev;
    private Integer collyear;
    private Integer bridge;
    private Date colldate;
    private Integer finaidreq;
    private Integer finaidreqa;
    private Integer finaidrec;
    private Integer finaidreca;
    private String finaidname;
    private String finaidunme;
    private Integer finaidreas;
    private Integer graaidreq;
    private Integer graaidreqa;
    private Integer graaidrec;
    private Integer graaidreca;
    private Integer endstatus;
    private Integer age;
    private Date lastcont;
    private Date lastmodify;
    private String lastuser;
    private Integer hscred;
    private Integer psecred;
    private Integer bridcred;
    private Integer bridnocred;
    private Integer pseterm;
    private Integer collready;
    private Integer gradestart;
    private Integer hsgradepro;
    private Integer hsgradstat;
    private Integer vcall;
    private Date vcalldate;
    private Date vcalldater;
    private String notes;
    private Integer recupdated;
    private Integer noenreason;
    private Integer mcnmajor;
    private Integer trackcomp;
    private String specialcir;
    private Integer fundsource;
    private Integer persistend;
    private Integer persiststa;
    private Integer transfers;
    private Integer degree;
    private Date degreedate;
    private Integer sumbridge;
    private Integer projretain;
    private Integer enrollobj;
    private Integer persistden;
    private Integer persistnum;
    private Integer state10rla;
    private Integer state10mat;
    private Integer vettest;
    private Integer mcresearch;
    private Integer mcintern;
    private Date timestamp_column;
    private Integer organizationid;
    private Integer deleted;
    private Integer DUALENROLL;
    private Integer RIGOROUS;
    private Integer OTHERTRIO;
    private Integer FAFSA;
    private Integer DECEASED;
    private Integer GPAUNWEIGH;
    private Integer SCHPERSIST;
    private Integer APCOURSE;
    private Integer DECREDENTI;
    private Integer ADVANCEMAT;
    private Integer EMPLOY;
    private Integer CERTI;
    private Date CERTIDT;
    private Integer ADEGREE;
    private Integer ADEGREEDT;
    private Integer BDEGREE;
    private Date BDEGREEDT;
    private Integer PSENROLL;
    private Integer PSREMEDIAT;
    private Integer PSCOMPLETE;
    private Integer STEMDEGREE;
    private String NAMECHANGE;
    private Integer MCSCHOLAR;
    private Integer GPERSIST;
    private Integer GRADSTUDYL;
    private String GRADSTUDY;
    private Integer GRADASSIST;
    private Integer GREASON;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getYearfi() {
        return yearfi;
    }

    public void setYearfi(Integer yearfi) {
        this.yearfi = yearfi;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getServed() {
        return served;
    }

    public void setServed(Integer served) {
        this.served = served;
    }

    public Integer getReported() {
        return reported;
    }

    public void setReported(Integer reported) {
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

    public Integer getCollegety() {
        return collegety;
    }

    public void setCollegety(Integer collegety) {
        this.collegety = collegety;
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

    public Integer getGpastart() {
        return gpastart;
    }

    public void setGpastart(Integer gpastart) {
        this.gpastart = gpastart;
    }

    public Integer getGpaend() {
        return gpaend;
    }

    public void setGpaend(Integer gpaend) {
        this.gpaend = gpaend;
    }

    public Integer getPartstatus() {
        return partstatus;
    }

    public void setPartstatus(Integer partstatus) {
        this.partstatus = partstatus;
    }

    public Date getRentrydate() {
        return rentrydate;
    }

    public void setRentrydate(Date rentrydate) {
        this.rentrydate = rentrydate;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getReasonleav() {
        return reasonleav;
    }

    public void setReasonleav(Integer reasonleav) {
        this.reasonleav = reasonleav;
    }

    public Integer getPartlevel() {
        return partlevel;
    }

    public void setPartlevel(Integer partlevel) {
        this.partlevel = partlevel;
    }

    public Integer getTesttype() {
        return testtype;
    }

    public void setTesttype(Integer testtype) {
        this.testtype = testtype;
    }

    public Integer getPsatscore() {
        return psatscore;
    }

    public void setPsatscore(Integer psatscore) {
        this.psatscore = psatscore;
    }

    public Integer getActplan() {
        return actplan;
    }

    public void setActplan(Integer actplan) {
        this.actplan = actplan;
    }

    public Integer getGradelevel() {
        return gradelevel;
    }

    public void setGradelevel(Integer gradelevel) {
        this.gradelevel = gradelevel;
    }

    public Integer getRecruit() {
        return recruit;
    }

    public void setRecruit(Integer recruit) {
        this.recruit = recruit;
    }

    public Integer getSelftran() {
        return selftran;
    }

    public void setSelftran(Integer selftran) {
        this.selftran = selftran;
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

    public Integer getPartlength() {
        return partlength;
    }

    public void setPartlength(Integer partlength) {
        this.partlength = partlength;
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

    public Integer getBridge() {
        return bridge;
    }

    public void setBridge(Integer bridge) {
        this.bridge = bridge;
    }

    public Date getColldate() {
        return colldate;
    }

    public void setColldate(Date colldate) {
        this.colldate = colldate;
    }

    public Integer getFinaidreq() {
        return finaidreq;
    }

    public void setFinaidreq(Integer finaidreq) {
        this.finaidreq = finaidreq;
    }

    public Integer getFinaidreqa() {
        return finaidreqa;
    }

    public void setFinaidreqa(Integer finaidreqa) {
        this.finaidreqa = finaidreqa;
    }

    public Integer getFinaidrec() {
        return finaidrec;
    }

    public void setFinaidrec(Integer finaidrec) {
        this.finaidrec = finaidrec;
    }

    public Integer getFinaidreca() {
        return finaidreca;
    }

    public void setFinaidreca(Integer finaidreca) {
        this.finaidreca = finaidreca;
    }

    public String getFinaidname() {
        return finaidname;
    }

    public void setFinaidname(String finaidname) {
        this.finaidname = finaidname;
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

    public Integer getGraaidreq() {
        return graaidreq;
    }

    public void setGraaidreq(Integer graaidreq) {
        this.graaidreq = graaidreq;
    }

    public Integer getGraaidreqa() {
        return graaidreqa;
    }

    public void setGraaidreqa(Integer graaidreqa) {
        this.graaidreqa = graaidreqa;
    }

    public Integer getGraaidrec() {
        return graaidrec;
    }

    public void setGraaidrec(Integer graaidrec) {
        this.graaidrec = graaidrec;
    }

    public Integer getGraaidreca() {
        return graaidreca;
    }

    public void setGraaidreca(Integer graaidreca) {
        this.graaidreca = graaidreca;
    }

    public Integer getEndstatus() {
        return endstatus;
    }

    public void setEndstatus(Integer endstatus) {
        this.endstatus = endstatus;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getLastcont() {
        return lastcont;
    }

    public void setLastcont(Date lastcont) {
        this.lastcont = lastcont;
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

    public Integer getCollready() {
        return collready;
    }

    public void setCollready(Integer collready) {
        this.collready = collready;
    }

    public Integer getGradestart() {
        return gradestart;
    }

    public void setGradestart(Integer gradestart) {
        this.gradestart = gradestart;
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

    public Date getVcalldate() {
        return vcalldate;
    }

    public void setVcalldate(Date vcalldate) {
        this.vcalldate = vcalldate;
    }

    public Date getVcalldater() {
        return vcalldater;
    }

    public void setVcalldater(Date vcalldater) {
        this.vcalldater = vcalldater;
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

    public Integer getTrackcomp() {
        return trackcomp;
    }

    public void setTrackcomp(Integer trackcomp) {
        this.trackcomp = trackcomp;
    }

    public String getSpecialcir() {
        return specialcir;
    }

    public void setSpecialcir(String specialcir) {
        this.specialcir = specialcir;
    }

    public Integer getFundsource() {
        return fundsource;
    }

    public void setFundsource(Integer fundsource) {
        this.fundsource = fundsource;
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

    public Date getDegreedate() {
        return degreedate;
    }

    public void setDegreedate(Date degreedate) {
        this.degreedate = degreedate;
    }

    public Integer getSumbridge() {
        return sumbridge;
    }

    public void setSumbridge(Integer sumbridge) {
        this.sumbridge = sumbridge;
    }

    public Integer getProjretain() {
        return projretain;
    }

    public void setProjretain(Integer projretain) {
        this.projretain = projretain;
    }

    public Integer getEnrollobj() {
        return enrollobj;
    }

    public void setEnrollobj(Integer enrollobj) {
        this.enrollobj = enrollobj;
    }

    public Integer getPersistden() {
        return persistden;
    }

    public void setPersistden(Integer persistden) {
        this.persistden = persistden;
    }

    public Integer getPersistnum() {
        return persistnum;
    }

    public void setPersistnum(Integer persistnum) {
        this.persistnum = persistnum;
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

    public Integer getVettest() {
        return vettest;
    }

    public void setVettest(Integer vettest) {
        this.vettest = vettest;
    }

    public Integer getMcresearch() {
        return mcresearch;
    }

    public void setMcresearch(Integer mcresearch) {
        this.mcresearch = mcresearch;
    }

    public Integer getMcintern() {
        return mcintern;
    }

    public void setMcintern(Integer mcintern) {
        this.mcintern = mcintern;
    }

    public Date getTimestamp_column() {
        return timestamp_column;
    }

    public void setTimestamp_column(Date timestamp_column) {
        this.timestamp_column = timestamp_column;
    }

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDUALENROLL() {
        return DUALENROLL;
    }

    public void setDUALENROLL(Integer DUALENROLL) {
        this.DUALENROLL = DUALENROLL;
    }

    public Integer getRIGOROUS() {
        return RIGOROUS;
    }

    public void setRIGOROUS(Integer RIGOROUS) {
        this.RIGOROUS = RIGOROUS;
    }

    public Integer getOTHERTRIO() {
        return OTHERTRIO;
    }

    public void setOTHERTRIO(Integer OTHERTRIO) {
        this.OTHERTRIO = OTHERTRIO;
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

    public Integer getGPAUNWEIGH() {
        return GPAUNWEIGH;
    }

    public void setGPAUNWEIGH(Integer GPAUNWEIGH) {
        this.GPAUNWEIGH = GPAUNWEIGH;
    }

    public Integer getSCHPERSIST() {
        return SCHPERSIST;
    }

    public void setSCHPERSIST(Integer SCHPERSIST) {
        this.SCHPERSIST = SCHPERSIST;
    }

    public Integer getAPCOURSE() {
        return APCOURSE;
    }

    public void setAPCOURSE(Integer APCOURSE) {
        this.APCOURSE = APCOURSE;
    }

    public Integer getDECREDENTI() {
        return DECREDENTI;
    }

    public void setDECREDENTI(Integer DECREDENTI) {
        this.DECREDENTI = DECREDENTI;
    }

    public Integer getADVANCEMAT() {
        return ADVANCEMAT;
    }

    public void setADVANCEMAT(Integer ADVANCEMAT) {
        this.ADVANCEMAT = ADVANCEMAT;
    }

    public Integer getEMPLOY() {
        return EMPLOY;
    }

    public void setEMPLOY(Integer EMPLOY) {
        this.EMPLOY = EMPLOY;
    }

    public Integer getCERTI() {
        return CERTI;
    }

    public void setCERTI(Integer CERTI) {
        this.CERTI = CERTI;
    }

    public Date getCERTIDT() {
        return CERTIDT;
    }

    public void setCERTIDT(Date CERTIDT) {
        this.CERTIDT = CERTIDT;
    }

    public Integer getADEGREE() {
        return ADEGREE;
    }

    public void setADEGREE(Integer ADEGREE) {
        this.ADEGREE = ADEGREE;
    }

    public Integer getADEGREEDT() {
        return ADEGREEDT;
    }

    public void setADEGREEDT(Integer ADEGREEDT) {
        this.ADEGREEDT = ADEGREEDT;
    }

    public Integer getBDEGREE() {
        return BDEGREE;
    }

    public void setBDEGREE(Integer BDEGREE) {
        this.BDEGREE = BDEGREE;
    }

    public Date getBDEGREEDT() {
        return BDEGREEDT;
    }

    public void setBDEGREEDT(Date BDEGREEDT) {
        this.BDEGREEDT = BDEGREEDT;
    }

    public Integer getPSENROLL() {
        return PSENROLL;
    }

    public void setPSENROLL(Integer PSENROLL) {
        this.PSENROLL = PSENROLL;
    }

    public Integer getPSREMEDIAT() {
        return PSREMEDIAT;
    }

    public void setPSREMEDIAT(Integer PSREMEDIAT) {
        this.PSREMEDIAT = PSREMEDIAT;
    }

    public Integer getPSCOMPLETE() {
        return PSCOMPLETE;
    }

    public void setPSCOMPLETE(Integer PSCOMPLETE) {
        this.PSCOMPLETE = PSCOMPLETE;
    }

    public Integer getSTEMDEGREE() {
        return STEMDEGREE;
    }

    public void setSTEMDEGREE(Integer STEMDEGREE) {
        this.STEMDEGREE = STEMDEGREE;
    }

    public String getNAMECHANGE() {
        return NAMECHANGE;
    }

    public void setNAMECHANGE(String NAMECHANGE) {
        this.NAMECHANGE = NAMECHANGE;
    }

    public Integer getMCSCHOLAR() {
        return MCSCHOLAR;
    }

    public void setMCSCHOLAR(Integer MCSCHOLAR) {
        this.MCSCHOLAR = MCSCHOLAR;
    }

    public Integer getGPERSIST() {
        return GPERSIST;
    }

    public void setGPERSIST(Integer GPERSIST) {
        this.GPERSIST = GPERSIST;
    }

    public Integer getGRADSTUDYL() {
        return GRADSTUDYL;
    }

    public void setGRADSTUDYL(Integer GRADSTUDYL) {
        this.GRADSTUDYL = GRADSTUDYL;
    }

    public String getGRADSTUDY() {
        return GRADSTUDY;
    }

    public void setGRADSTUDY(String GRADSTUDY) {
        this.GRADSTUDY = GRADSTUDY;
    }

    public Integer getGRADASSIST() {
        return GRADASSIST;
    }

    public void setGRADASSIST(Integer GRADASSIST) {
        this.GRADASSIST = GRADASSIST;
    }

    public Integer getGREASON() {
        return GREASON;
    }

    public void setGREASON(Integer GREASON) {
        this.GREASON = GREASON;
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

    private Integer completeyr;
    private Integer vcalllen;


}
