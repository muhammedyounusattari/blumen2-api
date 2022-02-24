package com.kastech.blumen.model.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kastech.blumen.controller.student.Activities;
import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "student" ,schema = "blumen2")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_seq_gen")
    @SequenceGenerator(name="student_seq_gen", sequenceName="student_SEQ")
    //Student data AS IS structure
    private String sfirst;
    private String slast;
    private String smi;
    private String address;
    private String city;
    private String state;
    private Integer zipcode;
    private String phone1;
    private String phone2;
    private String email;
    private String website;
    private Integer entrydate;
    private Date dob;
    private Date termidate;
    private Date finishdate;
    private Date collegedt;
    private Integer ethnic;
    private String ethnictype;
    private Integer eligibilit;
    private String eligtype;
    private Integer familysize;
    private Integer yearco;
    private Integer gender;
    private String imagepath;
    private String codes;
    private String custom1;
    private String custom2;
    private String schoolent;
    private String collegeent;
    private Integer gpaentry;
    private String incomesou;
    private Integer acadneed;
    private Integer enterlevel;
    private Integer gpascale;
    private Integer enterexam;
    private Integer satcomb;
    private Integer satverb;
    private Integer satmath;
    private Integer actcomp;
    private Integer finaidrecd;
    private Integer highdegree;
    private Integer venterlev;
    private Integer venterjob;
    private Integer vdisabled;
    private Integer vfinaidrec;
    private String referedby;
    private String incomelev;
    private Integer citizen;
    private Integer aliennum;
    private String birthplace;
    private String healthname;
    private Integer healthnum;
    private String medicaid;
    private String docname;
    private String docphone;
    private String studentid;
    private String dlnumber;
    private String dlstate;
    private String trioname;
    private Integer marrstatus;
    private Integer calgpa;
    private Integer phrsattemp;
    private Integer phrscomp;
    private Integer phrsgpa;
    private Integer pgpa;
    private Integer pgpapoints;
    private Integer hrsattemp;
    private Integer hrscomp;
    private Integer hrsgpa;
    private Integer gpa;
    private Integer gpapoints;
    private Date lastmodify;
    private String notes;
    private String lastuser;
    private String schoolend;
    private String collegendd;
    private String yearproj;
    private String acadneed2;
    private String egraddate;
    private String graddate;
    private Integer msgpascale;
    private Integer msgpa;
    private Integer lepentry;
    private Integer leplastser;
    private Integer statetest;
    private Integer state8rla;
    private Integer state8math;
    private Integer state10rla;
    private Integer staterlagr;
    private Integer state10mat;
    private Integer statemathg;
    private Integer eligi1;
    private Integer eligi2;
    private Integer eligi3;
    private Date degreedate;
    private Integer satwriting;
    private Date firstserdt;
    private Integer cohortyear;
    private Integer ethnic1;
    private Integer ethnic2;
    private Integer ethnic3;
    private Integer ethnic4;
    private Integer ethnic5;
    private Integer ethnic6;
    private Integer yearcogrd;
    private Integer vetsche;
    private Integer vetrevsche;
    private Integer vetschecir;
    private Integer vetscherea;
    private String mainuid;
    private Integer stuid;
    private Integer deleted;
    private Integer organizationid;
    private Integer enterenrol;
    private Integer TRACK;
    private Integer TRACKYEAR;
    private Integer RANDOMID;
    private Integer ATRSTDTEST;
    private Integer ATRLOWGPA;
    private Integer ATRALGEBRA;
    private Integer DISCONNECT;
    private Integer COLLCOHORT;
    private Integer COMMCOLL;
    private Integer MCSTEM;
    private Integer BDEGREE;
    private String BDEGREEDT;
    private Integer BDEGREECO;
    private String BDEGREEMA;
    private Integer GRADADM;
    private String GRADENRODT;
    private String GRADCOLL;
    private Integer GDEGREE;
    private String GDEGREEDT;
    private String GDOCCOLL;
    private Integer DOCEMPLOY;
    private Integer atrschool;
    private String sitelocate;
    private String phn1ty;
    private String phn1txt;
    private String phn2ty;
    private String phn2txt;
    private String scanid;
    private String casenum;
    private String fiscalYear;

    @OneToOne(cascade = {CascadeType.ALL})
    private GraduatedInformation graduatedInformation;

    @OneToOne(cascade = {CascadeType.ALL})
    private StudentYearlyData studentYearlyData;

    public StudentYearlyData getStudentYearlyData() {
        return studentYearlyData;
    }

    public void setStudentYearlyData(StudentYearlyData studentYearlyData) {
        this.studentYearlyData = studentYearlyData;
    }

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<TeacherClasses> teacherClasses = new HashSet<TeacherClasses>();

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<CounselorClasses> counselorClasses = new HashSet<CounselorClasses>();

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<StaffClasses> staffClasses = new HashSet<StaffClasses>();

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<TutorClasses> tutorClasses = new HashSet<TutorClasses>();

    private boolean isDeletedStudent;

    public Student() {
    }

    public boolean isDeletedStudent() {
        return isDeletedStudent;
    }

    public void setDeletedStudent(boolean deletedStudent) {
        isDeletedStudent = deletedStudent;
    }

    public void assignTeacherClasses(TeacherClasses teacherClass) {
        this.teacherClasses.add(teacherClass);
        teacherClass.getStudentList().add(this);
    }

    public void removeTeacherClasses(TeacherClasses teacherClass) {
        this.teacherClasses.remove(teacherClass);
        teacherClass.getStudentList().remove(this);
    }

    public void assignCounselorClasses(CounselorClasses CounselorClass) {
        this.counselorClasses.add(CounselorClass);
        CounselorClass.getStudentList().add(this);
    }

    public void removeCounselorClasses(CounselorClasses CounselorClass) {
        this.counselorClasses.remove(CounselorClass);
        CounselorClass.getStudentList().remove(this);
    }

    public void assignStaffClasses(StaffClasses StaffClass) {
        this.staffClasses.add(StaffClass);
        StaffClass.getStudentList().add(this);
    }

    public void removeStaffClasses(StaffClasses StaffClass) {
        this.staffClasses.remove(StaffClass);
        StaffClass.getStudentList().remove(this);
    }

    public void assignTutorClasses(TutorClasses tutorClass) {
        this.tutorClasses.add(tutorClass);
        tutorClass.getStudentList().add(this);
    }

    public void removeTutorClasses(TutorClasses tutorClass) {
        this.tutorClasses.remove(tutorClass);
        tutorClass.getStudentList().remove(this);
    }


    public GraduatedInformation getGraduatedInformation() {
        return graduatedInformation;
    }

    public void setGraduatedInformation(GraduatedInformation graduatedInformation) {
        this.graduatedInformation = graduatedInformation;
    }

    public Set<TeacherClasses> getTeacherClasses() {
        return teacherClasses;
    }

    public void setTeacherClasses(Set<TeacherClasses> teacherClasses) {
        this.teacherClasses = teacherClasses;
    }

    public Set<CounselorClasses> getCounselorClasses() {
        return counselorClasses;
    }

    public void setCounselorClasses(Set<CounselorClasses> counselorClasses) {
        this.counselorClasses = counselorClasses;
    }

    public Set<StaffClasses> getStaffClasses() {
        return staffClasses;
    }

    public void setStaffClasses(Set<StaffClasses> staffClasses) {
        this.staffClasses = staffClasses;
    }

    public Set<TutorClasses> getTutorClasses() {
        return tutorClasses;
    }

    public void setTutorClasses(Set<TutorClasses> tutorClasses) {
        this.tutorClasses = tutorClasses;
    }

    public String getSfirst() {
        return sfirst;
    }

    public void setSfirst(String sfirst) {
        this.sfirst = sfirst;
    }

    public String getSlast() {
        return slast;
    }

    public void setSlast(String slast) {
        this.slast = slast;
    }

    public String getSmi() {
        return smi;
    }

    public void setSmi(String smi) {
        this.smi = smi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Integer entrydate) {
        this.entrydate = entrydate;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getTermidate() {
        return termidate;
    }

    public void setTermidate(Date termidate) {
        this.termidate = termidate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Date getCollegedt() {
        return collegedt;
    }

    public void setCollegedt(Date collegedt) {
        this.collegedt = collegedt;
    }

    public Integer getEthnic() {
        return ethnic;
    }

    public void setEthnic(Integer ethnic) {
        this.ethnic = ethnic;
    }

    public String getEthnictype() {
        return ethnictype;
    }

    public void setEthnictype(String ethnictype) {
        this.ethnictype = ethnictype;
    }

    public Integer getEligibilit() {
        return eligibilit;
    }

    public void setEligibilit(Integer eligibilit) {
        this.eligibilit = eligibilit;
    }

    public String getEligtype() {
        return eligtype;
    }

    public void setEligtype(String eligtype) {
        this.eligtype = eligtype;
    }

    public Integer getFamilysize() {
        return familysize;
    }

    public void setFamilysize(Integer familysize) {
        this.familysize = familysize;
    }

    public Integer getYearco() {
        return yearco;
    }

    public void setYearco(Integer yearco) {
        this.yearco = yearco;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getSchoolent() {
        return schoolent;
    }

    public void setSchoolent(String schoolent) {
        this.schoolent = schoolent;
    }

    public String getCollegeent() {
        return collegeent;
    }

    public void setCollegeent(String collegeent) {
        this.collegeent = collegeent;
    }

    public Integer getGpaentry() {
        return gpaentry;
    }

    public void setGpaentry(Integer gpaentry) {
        this.gpaentry = gpaentry;
    }

    public String getIncomesou() {
        return incomesou;
    }

    public void setIncomesou(String incomesou) {
        this.incomesou = incomesou;
    }

    public Integer getAcadneed() {
        return acadneed;
    }

    public void setAcadneed(Integer acadneed) {
        this.acadneed = acadneed;
    }

    public Integer getEnterlevel() {
        return enterlevel;
    }

    public void setEnterlevel(Integer enterlevel) {
        this.enterlevel = enterlevel;
    }

    public Integer getGpascale() {
        return gpascale;
    }

    public void setGpascale(Integer gpascale) {
        this.gpascale = gpascale;
    }

    public Integer getEnterexam() {
        return enterexam;
    }

    public void setEnterexam(Integer enterexam) {
        this.enterexam = enterexam;
    }

    public Integer getSatcomb() {
        return satcomb;
    }

    public void setSatcomb(Integer satcomb) {
        this.satcomb = satcomb;
    }

    public Integer getSatverb() {
        return satverb;
    }

    public void setSatverb(Integer satverb) {
        this.satverb = satverb;
    }

    public Integer getSatmath() {
        return satmath;
    }

    public void setSatmath(Integer satmath) {
        this.satmath = satmath;
    }

    public Integer getActcomp() {
        return actcomp;
    }

    public void setActcomp(Integer actcomp) {
        this.actcomp = actcomp;
    }

    public Integer getFinaidrecd() {
        return finaidrecd;
    }

    public void setFinaidrecd(Integer finaidrecd) {
        this.finaidrecd = finaidrecd;
    }

    public Integer getHighdegree() {
        return highdegree;
    }

    public void setHighdegree(Integer highdegree) {
        this.highdegree = highdegree;
    }

    public Integer getVenterlev() {
        return venterlev;
    }

    public void setVenterlev(Integer venterlev) {
        this.venterlev = venterlev;
    }

    public Integer getVenterjob() {
        return venterjob;
    }

    public void setVenterjob(Integer venterjob) {
        this.venterjob = venterjob;
    }

    public Integer getVdisabled() {
        return vdisabled;
    }

    public void setVdisabled(Integer vdisabled) {
        this.vdisabled = vdisabled;
    }

    public Integer getVfinaidrec() {
        return vfinaidrec;
    }

    public void setVfinaidrec(Integer vfinaidrec) {
        this.vfinaidrec = vfinaidrec;
    }

    public String getReferedby() {
        return referedby;
    }

    public void setReferedby(String referedby) {
        this.referedby = referedby;
    }

    public String getIncomelev() {
        return incomelev;
    }

    public void setIncomelev(String incomelev) {
        this.incomelev = incomelev;
    }

    public Integer getCitizen() {
        return citizen;
    }

    public void setCitizen(Integer citizen) {
        this.citizen = citizen;
    }

    public Integer getAliennum() {
        return aliennum;
    }

    public void setAliennum(Integer aliennum) {
        this.aliennum = aliennum;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getHealthname() {
        return healthname;
    }

    public void setHealthname(String healthname) {
        this.healthname = healthname;
    }

    public Integer getHealthnum() {
        return healthnum;
    }

    public void setHealthnum(Integer healthnum) {
        this.healthnum = healthnum;
    }

    public String getMedicaid() {
        return medicaid;
    }

    public void setMedicaid(String medicaid) {
        this.medicaid = medicaid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocphone() {
        return docphone;
    }

    public void setDocphone(String docphone) {
        this.docphone = docphone;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getDlnumber() {
        return dlnumber;
    }

    public void setDlnumber(String dlnumber) {
        this.dlnumber = dlnumber;
    }

    public String getDlstate() {
        return dlstate;
    }

    public void setDlstate(String dlstate) {
        this.dlstate = dlstate;
    }

    public String getTrioname() {
        return trioname;
    }

    public void setTrioname(String trioname) {
        this.trioname = trioname;
    }

    public Integer getMarrstatus() {
        return marrstatus;
    }

    public void setMarrstatus(Integer marrstatus) {
        this.marrstatus = marrstatus;
    }

    public Integer getCalgpa() {
        return calgpa;
    }

    public void setCalgpa(Integer calgpa) {
        this.calgpa = calgpa;
    }

    public Integer getPhrsattemp() {
        return phrsattemp;
    }

    public void setPhrsattemp(Integer phrsattemp) {
        this.phrsattemp = phrsattemp;
    }

    public Integer getPhrscomp() {
        return phrscomp;
    }

    public void setPhrscomp(Integer phrscomp) {
        this.phrscomp = phrscomp;
    }

    public Integer getPhrsgpa() {
        return phrsgpa;
    }

    public void setPhrsgpa(Integer phrsgpa) {
        this.phrsgpa = phrsgpa;
    }

    public Integer getPgpa() {
        return pgpa;
    }

    public void setPgpa(Integer pgpa) {
        this.pgpa = pgpa;
    }

    public Integer getPgpapoints() {
        return pgpapoints;
    }

    public void setPgpapoints(Integer pgpapoints) {
        this.pgpapoints = pgpapoints;
    }

    public Integer getHrsattemp() {
        return hrsattemp;
    }

    public void setHrsattemp(Integer hrsattemp) {
        this.hrsattemp = hrsattemp;
    }

    public Integer getHrscomp() {
        return hrscomp;
    }

    public void setHrscomp(Integer hrscomp) {
        this.hrscomp = hrscomp;
    }

    public Integer getHrsgpa() {
        return hrsgpa;
    }

    public void setHrsgpa(Integer hrsgpa) {
        this.hrsgpa = hrsgpa;
    }

    public Integer getGpa() {
        return gpa;
    }

    public void setGpa(Integer gpa) {
        this.gpa = gpa;
    }

    public Integer getGpapoints() {
        return gpapoints;
    }

    public void setGpapoints(Integer gpapoints) {
        this.gpapoints = gpapoints;
    }

    public Date getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(Date lastmodify) {
        this.lastmodify = lastmodify;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLastuser() {
        return lastuser;
    }

    public void setLastuser(String lastuser) {
        this.lastuser = lastuser;
    }

    public String getSchoolend() {
        return schoolend;
    }

    public void setSchoolend(String schoolend) {
        this.schoolend = schoolend;
    }

    public String getCollegendd() {
        return collegendd;
    }

    public void setCollegendd(String collegendd) {
        this.collegendd = collegendd;
    }

    public String getYearproj() {
        return yearproj;
    }

    public void setYearproj(String yearproj) {
        this.yearproj = yearproj;
    }

    public String getAcadneed2() {
        return acadneed2;
    }

    public void setAcadneed2(String acadneed2) {
        this.acadneed2 = acadneed2;
    }

    public String getEgraddate() {
        return egraddate;
    }

    public void setEgraddate(String egraddate) {
        this.egraddate = egraddate;
    }

    public String getGraddate() {
        return graddate;
    }

    public void setGraddate(String graddate) {
        this.graddate = graddate;
    }

    public Integer getMsgpascale() {
        return msgpascale;
    }

    public void setMsgpascale(Integer msgpascale) {
        this.msgpascale = msgpascale;
    }

    public Integer getMsgpa() {
        return msgpa;
    }

    public void setMsgpa(Integer msgpa) {
        this.msgpa = msgpa;
    }

    public Integer getLepentry() {
        return lepentry;
    }

    public void setLepentry(Integer lepentry) {
        this.lepentry = lepentry;
    }

    public Integer getLeplastser() {
        return leplastser;
    }

    public void setLeplastser(Integer leplastser) {
        this.leplastser = leplastser;
    }

    public Integer getStatetest() {
        return statetest;
    }

    public void setStatetest(Integer statetest) {
        this.statetest = statetest;
    }

    public Integer getState8rla() {
        return state8rla;
    }

    public void setState8rla(Integer state8rla) {
        this.state8rla = state8rla;
    }

    public Integer getState8math() {
        return state8math;
    }

    public void setState8math(Integer state8math) {
        this.state8math = state8math;
    }

    public Integer getState10rla() {
        return state10rla;
    }

    public void setState10rla(Integer state10rla) {
        this.state10rla = state10rla;
    }

    public Integer getStaterlagr() {
        return staterlagr;
    }

    public void setStaterlagr(Integer staterlagr) {
        this.staterlagr = staterlagr;
    }

    public Integer getState10mat() {
        return state10mat;
    }

    public void setState10mat(Integer state10mat) {
        this.state10mat = state10mat;
    }

    public Integer getStatemathg() {
        return statemathg;
    }

    public void setStatemathg(Integer statemathg) {
        this.statemathg = statemathg;
    }

    public Integer getEligi1() {
        return eligi1;
    }

    public void setEligi1(Integer eligi1) {
        this.eligi1 = eligi1;
    }

    public Integer getEligi2() {
        return eligi2;
    }

    public void setEligi2(Integer eligi2) {
        this.eligi2 = eligi2;
    }

    public Integer getEligi3() {
        return eligi3;
    }

    public void setEligi3(Integer eligi3) {
        this.eligi3 = eligi3;
    }

    public Date getDegreedate() {
        return degreedate;
    }

    public void setDegreedate(Date degreedate) {
        this.degreedate = degreedate;
    }

    public Integer getSatwriting() {
        return satwriting;
    }

    public void setSatwriting(Integer satwriting) {
        this.satwriting = satwriting;
    }

    public Date getFirstserdt() {
        return firstserdt;
    }

    public void setFirstserdt(Date firstserdt) {
        this.firstserdt = firstserdt;
    }

    public Integer getCohortyear() {
        return cohortyear;
    }

    public void setCohortyear(Integer cohortyear) {
        this.cohortyear = cohortyear;
    }

    public Integer getEthnic1() {
        return ethnic1;
    }

    public void setEthnic1(Integer ethnic1) {
        this.ethnic1 = ethnic1;
    }

    public Integer getEthnic2() {
        return ethnic2;
    }

    public void setEthnic2(Integer ethnic2) {
        this.ethnic2 = ethnic2;
    }

    public Integer getEthnic3() {
        return ethnic3;
    }

    public void setEthnic3(Integer ethnic3) {
        this.ethnic3 = ethnic3;
    }

    public Integer getEthnic4() {
        return ethnic4;
    }

    public void setEthnic4(Integer ethnic4) {
        this.ethnic4 = ethnic4;
    }

    public Integer getEthnic5() {
        return ethnic5;
    }

    public void setEthnic5(Integer ethnic5) {
        this.ethnic5 = ethnic5;
    }

    public Integer getEthnic6() {
        return ethnic6;
    }

    public void setEthnic6(Integer ethnic6) {
        this.ethnic6 = ethnic6;
    }

    public Integer getYearcogrd() {
        return yearcogrd;
    }

    public void setYearcogrd(Integer yearcogrd) {
        this.yearcogrd = yearcogrd;
    }

    public Integer getVetsche() {
        return vetsche;
    }

    public void setVetsche(Integer vetsche) {
        this.vetsche = vetsche;
    }

    public Integer getVetrevsche() {
        return vetrevsche;
    }

    public void setVetrevsche(Integer vetrevsche) {
        this.vetrevsche = vetrevsche;
    }

    public Integer getVetschecir() {
        return vetschecir;
    }

    public void setVetschecir(Integer vetschecir) {
        this.vetschecir = vetschecir;
    }

    public Integer getVetscherea() {
        return vetscherea;
    }

    public void setVetscherea(Integer vetscherea) {
        this.vetscherea = vetscherea;
    }

    public String getMainuid() {
        return mainuid;
    }

    public void setMainuid(String mainuid) {
        this.mainuid = mainuid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public Integer getEnterenrol() {
        return enterenrol;
    }

    public void setEnterenrol(Integer enterenrol) {
        this.enterenrol = enterenrol;
    }

    public Integer getTRACK() {
        return TRACK;
    }

    public void setTRACK(Integer TRACK) {
        this.TRACK = TRACK;
    }

    public Integer getTRACKYEAR() {
        return TRACKYEAR;
    }

    public void setTRACKYEAR(Integer TRACKYEAR) {
        this.TRACKYEAR = TRACKYEAR;
    }

    public Integer getRANDOMID() {
        return RANDOMID;
    }

    public void setRANDOMID(Integer RANDOMID) {
        this.RANDOMID = RANDOMID;
    }

    public Integer getATRSTDTEST() {
        return ATRSTDTEST;
    }

    public void setATRSTDTEST(Integer ATRSTDTEST) {
        this.ATRSTDTEST = ATRSTDTEST;
    }

    public Integer getATRLOWGPA() {
        return ATRLOWGPA;
    }

    public void setATRLOWGPA(Integer ATRLOWGPA) {
        this.ATRLOWGPA = ATRLOWGPA;
    }

    public Integer getATRALGEBRA() {
        return ATRALGEBRA;
    }

    public void setATRALGEBRA(Integer ATRALGEBRA) {
        this.ATRALGEBRA = ATRALGEBRA;
    }

    public Integer getDISCONNECT() {
        return DISCONNECT;
    }

    public void setDISCONNECT(Integer DISCONNECT) {
        this.DISCONNECT = DISCONNECT;
    }

    public Integer getCOLLCOHORT() {
        return COLLCOHORT;
    }

    public void setCOLLCOHORT(Integer COLLCOHORT) {
        this.COLLCOHORT = COLLCOHORT;
    }

    public Integer getCOMMCOLL() {
        return COMMCOLL;
    }

    public void setCOMMCOLL(Integer COMMCOLL) {
        this.COMMCOLL = COMMCOLL;
    }

    public Integer getMCSTEM() {
        return MCSTEM;
    }

    public void setMCSTEM(Integer MCSTEM) {
        this.MCSTEM = MCSTEM;
    }

    public Integer getBDEGREE() {
        return BDEGREE;
    }

    public void setBDEGREE(Integer BDEGREE) {
        this.BDEGREE = BDEGREE;
    }

    public String getBDEGREEDT() {
        return BDEGREEDT;
    }

    public void setBDEGREEDT(String BDEGREEDT) {
        this.BDEGREEDT = BDEGREEDT;
    }

    public Integer getBDEGREECO() {
        return BDEGREECO;
    }

    public void setBDEGREECO(Integer BDEGREECO) {
        this.BDEGREECO = BDEGREECO;
    }

    public String getBDEGREEMA() {
        return BDEGREEMA;
    }

    public void setBDEGREEMA(String BDEGREEMA) {
        this.BDEGREEMA = BDEGREEMA;
    }

    public Integer getGRADADM() {
        return GRADADM;
    }

    public void setGRADADM(Integer GRADADM) {
        this.GRADADM = GRADADM;
    }

    public String getGRADENRODT() {
        return GRADENRODT;
    }

    public void setGRADENRODT(String GRADENRODT) {
        this.GRADENRODT = GRADENRODT;
    }

    public String getGRADCOLL() {
        return GRADCOLL;
    }

    public void setGRADCOLL(String GRADCOLL) {
        this.GRADCOLL = GRADCOLL;
    }

    public Integer getGDEGREE() {
        return GDEGREE;
    }

    public void setGDEGREE(Integer GDEGREE) {
        this.GDEGREE = GDEGREE;
    }

    public String getGDEGREEDT() {
        return GDEGREEDT;
    }

    public void setGDEGREEDT(String GDEGREEDT) {
        this.GDEGREEDT = GDEGREEDT;
    }

    public String getGDOCCOLL() {
        return GDOCCOLL;
    }

    public void setGDOCCOLL(String GDOCCOLL) {
        this.GDOCCOLL = GDOCCOLL;
    }

    public Integer getDOCEMPLOY() {
        return DOCEMPLOY;
    }

    public void setDOCEMPLOY(Integer DOCEMPLOY) {
        this.DOCEMPLOY = DOCEMPLOY;
    }

    public Integer getAtrschool() {
        return atrschool;
    }

    public void setAtrschool(Integer atrschool) {
        this.atrschool = atrschool;
    }

    public String getSitelocate() {
        return sitelocate;
    }

    public void setSitelocate(String sitelocate) {
        this.sitelocate = sitelocate;
    }

    public String getPhn1ty() {
        return phn1ty;
    }

    public void setPhn1ty(String phn1ty) {
        this.phn1ty = phn1ty;
    }

    public String getPhn1txt() {
        return phn1txt;
    }

    public void setPhn1txt(String phn1txt) {
        this.phn1txt = phn1txt;
    }

    public String getPhn2ty() {
        return phn2ty;
    }

    public void setPhn2ty(String phn2ty) {
        this.phn2ty = phn2ty;
    }

    public String getPhn2txt() {
        return phn2txt;
    }

    public void setPhn2txt(String phn2txt) {
        this.phn2txt = phn2txt;
    }

    public String getScanid() {
        return scanid;
    }

    public void setScanid(String scanid) {
        this.scanid = scanid;
    }

    public String getCasenum() {
        return casenum;
    }

    public void setCasenum(String casenum) {
        this.casenum = casenum;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
}
