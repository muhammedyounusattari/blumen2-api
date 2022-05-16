package com.kastech.blumen.model.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kastech.blumen.controller.student.Activities;
import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "student" ,schema = "blumen2")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stuid;

    @NotNull
    @Column(name = "sfirst", length = 50, nullable = false)
    private String sfirst;

    @NotNull
    @Column(name = "slast", length = 50, nullable = false)
    private String slast;

    @Column(name = "smi", length = 50)
    private String smi;

    @Column(name = "address", length = 16)
    private String address;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "zipcode", length = 50)
    private String zipcode;

    @Column(name = "phone1", length = 50)
    private String phone1;

    @Column(name = "phone2", length = 50)
    private String phone2;

    @Column(name = "email", length = 16)
    private String email;

    @Column(name = "website", length = 16)
    private String website;

    @Column(name = "entrydate", length = 8)
    private Timestamp entryDate;

    @Column(name = "dob", length = 8)
    private Timestamp dob;

    @Column(name = "termidate", length = 8)
    private Timestamp termiDate;

    @Column(name = "finishdate", length = 8)
    private Timestamp finishDate;

    @Column(name = "collegedt", length = 50)
    private String collegedt;

    @Column(name = "ethnic", length = 4, precision = 10)
    private Integer ethnic;

    @Column(name = "ethnictype", length = 50)
    private String ethnicType;

    @Column(name = "eligibilit", length = 4, precision = 10)
    private Integer eligibilit;

    @Column(name = "eligtype", length = 50)
    private String eligType;

    @Column(name = "familysize", length = 4, precision = 10)
    private Integer familySize;

    @NotNull
    @Column(name = "yearco", length = 4, precision = 10, nullable = false)
    private Integer yearco;

    @Column(name = "gender", length = 8,  precision = 53)
    private Float gender;

    @Column(name = "imagepath", length = 50)
    private String imagePath;

    @Column(name = "codes", length = 50)
    private String codes;

    @Column(name = "custom1", length = 50)
    private String custom1;

    @Column(name = "custom2", length = 50)
    private String custom2;

    @Column(name = "schoolent", length = 500)
    private String schoolent;

    @Column(name = "collegeent", length = 500)
    private String collegeent;

    @Column(name = "gpaentry", length = 8,  precision = 53)
    private Integer gpaentry;

    @Column(name = "incomesou", length = 50)
    private String incomesou;

    @Column(name = "acadneed", length = 4, precision = 10)
    private Integer acadNeed;

    @Column(name = "enterlevel", length = 4, precision = 10)
    private Integer enterLevel;

    @Column(name = "gpascale", length = 4, precision = 10)
    private Integer gpaScale;

    @Column(name = "enterexam", length = 4, precision = 10)
    private Integer enterExam;

    @Column(name = "satcomb", length = 4, precision = 10)
    private Integer satComb;

    @Column(name = "satverb", length = 4, precision = 10)
    private Integer satVerb;

    @Column(name = "satmath", length = 4, precision = 10)
    private Integer satMath;

    @Column(name = "actcomp", length = 4, precision = 10)
    private Integer actComp;

    @Column(name = "finaidrecd", length = 4, precision = 10)
    private Integer finaidrecd;

    @Column(name = "highdegree", length = 4, precision = 10)
    private Integer highDegree;

    @Column(name = "venterlev", length = 4, precision = 10)
    private Integer venterlev;

    @Column(name = "venterjob", length = 4, precision = 10)
    private Integer venterJob;

    @Column(name = "vDisabled", length = 4, precision = 10)
    private Integer vDisabled;

    @Column(name = "vfinaidrec", length = 4, precision = 10)
    private Integer vFinaidrec;

    @Column(name = "referedby", length = 50)
    private String referedBy;

    @Column(name = "incomelev", length = 50)
    private String incomeLev;

    @Column(name = "citizen", length = 1)
    private Boolean citizen;

    @Column(name = "aliennum", length = 50)
    private String aliennum;

    @Column(name = "birthplace", length = 50)
    private String birthPlace;

    @Column(name = "healthname", length = 50)
    private String healthName;

    @Column(name = "healthnum", length = 50)
    private String healthNum;

    @Column(name = "medicaid", length = 50)
    private String medicaid;

    @Column(name = "docname", length = 50)
    private String docName;

    @Column(name = "docphone", length = 50)
    private String docPhone;

    @Column(name = "studentid", length = 50)
    private String studentId;

    @Column(name = "dlnumber", length = 50)
    private String dlNumber;

    @Column(name = "dlstate", length = 50)
    private String dlState;

    @Column(name = "trioname", length = 50)
    private String trioName;

    @Column(name = "marrstatus", length = 4, precision = 10)
    private Integer marrStatus;

    @Column(name = "calgpa", length = 1)
    private Boolean calgpa;

    @Column(name = "phrsattemp", length = 8, precision = 53)
    private Float phrsatTemp;

    @Column(name = "phrscomp", length = 8, precision = 53)
    private Float phrsComp;

    @Column(name = "phrsgpa", length = 8, precision = 53)
    private Float phrsgpa;

    @Column(name = "pgpa", length = 8, precision = 53)
    private Float pgpa;

    @Column(name = "pgpapoints", length = 8, precision = 53)
    private Float pgpaPoints;

    @Column(name = "hrsattemp", length = 8, precision = 53)
    private Float hrsatTemp;

    @Column(name = "hrscomp", length = 8, precision = 53)
    private Float hrscomp;

    @Column(name = "hrsgpa", length = 8, precision = 53)
    private Float hrsgpa;

    @Column(name = "gpa", length = 8, precision = 53)
    private Float gpa;

    @Column(name = "gpapoints", length = 8, precision = 53)
    private Float gpaPoints;

    @Column(name = "lastmodify", length = 8)
    private Timestamp lastModify;

    @Column(name = "notes", length = 16)
    private String notes;

    @Column(name = "lastuser", length = 50)
    private String lastUser;

    @Column(name = "schoolend", length = 50)
    private String schoolEnd;

    @Column(name = "collegendd", length = 50)
    private String collegendd;

    @Column(name = "yearproj", length = 4, precision = 10)
    private Integer yearProj;

    @Column(name = "acadneed2", length = 4, precision = 10)
    private Integer acadneed2;

    @Column(name = "egraddate", length = 8)
    private Timestamp egradDate;

    @Column(name = "graddate", length = 8)
    private Timestamp gradDate;

    @Column(name = "msgpascale", length = 4, precision = 10)
    private Integer msgpaScale;

    @Column(name = "msgpa", length = 8, precision = 53)
    private Float msgpa;

    @Column(name = "lepentry", length = 4, precision = 10)
    private Integer lepentry;

    @Column(name = "leplastser", length = 4, precision = 10)
    private Integer leplastser;

    @Column(name = "statetest", length = 4, precision = 10)
    private Integer stateTest;

    @Column(name = "state8rla", length = 4, precision = 10)
    private Integer state8rla;

    @Column(name = "state8math", length = 4, precision = 10)
    private Integer state8math;

    @Column(name = "state10rla", length = 4, precision = 10)
    private Integer state10rla;

    @Column(name = "staterlagr", length = 4, precision = 10)
    private Integer staterlagr;

    @Column(name = "state10mat", length = 4, precision = 10)
    private Integer state10mat;

    @Column(name = "statemathg", length = 4, precision = 10)
    private Integer statemathg;

    @Column(name = "eligi1", length = 4, precision = 10)
    private Integer eligi1;

    @Column(name = "eligi2", length = 4, precision = 10)
    private Integer eligi2;

    @Column(name = "eligi3", length = 4, precision = 10)
    private Integer eligi3;

    @Column(name = "degreedate", length = 8)
    private Timestamp degreeDate;

    @Column(name = "satwriting", length = 4, precision = 10)
    private Integer satWriting;

    @Column(name = "firstserdt", length = 8)
    private Timestamp firstserdt;

    @Column(name = "cohortyear", length = 4, precision = 10)
    private Integer cohortYear;

    @Column(name = "ethnic1", length = 4, precision = 10)
    private Integer ethnic1;

    @Column(name = "ethnic2", length = 4, precision = 10)
    private Integer ethnic2;

    @Column(name = "ethnic3", length = 4, precision = 10)
    private Integer ethnic3;

    @Column(name = "ethnic4", length = 4, precision = 10)
    private Integer ethnic4;

    @Column(name = "ethnic5", length = 4, precision = 10)
    private Integer ethnic5;

    @Column(name = "ethnic6", length = 4, precision = 10)
    private Integer ethnic6;

    @Column(name = "yearcogrd", length = 4, precision = 10)
    private Integer yearcogrd;

    @Column(name = "vetsche", length = 4, precision = 10)
    private Integer vetsche;

    @Column(name = "vetrevsche", length = 4, precision = 10)
    private Integer vetrevsche;

    @Column(name = "vetschecir", length = 4, precision = 10)
    private Integer vetschecir;

    @Column(name = "vetscherea", length = 4, precision = 10)
    private Integer vetscherea;

    @Size(min = 9, max = 9)
    @Column(name = "mainuid", length = 9)
    private String mainuId;

    @NotNull
    @Column(name = "deleted", length = 1, nullable = false)
    private Boolean deleted;

    @NotNull
    @Column(name = "organizationid", length = 4, precision = 10, nullable = false)
    private Integer organizationId;

    @Column(name = "enterenrol", length = 4, precision = 10)
    private Integer enterenrol;

    @Column(name = "TRACK", length = 4, precision = 10)
    private Integer track;

    @Column(name = "TRACKYEAR", length = 4, precision = 10)
    private Integer trackYear;

    @Column(name = "RANDOMID", length = 4, precision = 10)
    private Integer randomId;

    @Column(name = "ATRSTDTEST", length = 4, precision = 10)
    private Integer atrstdTest;

    @Column(name = "ATRLOWGPA", length = 4, precision = 10)
    private Integer atrlowgpa;

    @Column(name = "ATRALGEBRA", length = 4, precision = 10)
    private Integer atrAlgebra;

    @Column(name = "DISCONNECT", length = 4, precision = 10)
    private Integer disconnect;

    @Column(name = "COLLCOHORT", length = 4, precision = 10)
    private Integer collcohort;

    @Column(name = "COMMCOLL", length = 4, precision = 10)
    private Integer commcoll;

    @Column(name = "MCSTEM", length = 4, precision = 10)
    private Integer mcstem;

    @Column(name = "BDEGREE", length = 4, precision = 10)
    private Integer bDegree;

    @Column(name = "BDEGREEDT", length = 50)
    private String bDegreedt;

    @Column(name = "BDEGREECO", length = 4, precision = 10)
    private Integer bDegreeco;

    @Column(name = "BDEGREEMA", length = 200)
    private String dDegreema;

    @Column(name = "GRADADM", length = 4, precision = 10)
    private Integer gradadm;

    @Column(name = "GRADENRODT", length = 50)
    private String gradenRodt;

    @Column(name = "GRADCOLL", length = 200)
    private String gradcoll;

    @Column(name = "GDEGREE", length = 4, precision = 10)
    private Integer gDegree;

    @Column(name = "GDEGREEDT", length = 50)
    private String gDegreedt;

    @Column(name = "GDOCCOLL", length = 200)
    private String gdoccoll;

    @Column(name = "DOCEMPLOY", length = 4, precision = 10)
    private Integer docEmploy;

    @Column(name = "atrschool", length = 4, precision = 10)
    private Integer atrSchool;

    @Column(name = "sitelocate", length = 100)
    private String siteLocate;

    @Column(name = "phn1ty", length = 50)
    private String phn1ty;

    @Column(name = "phn1txt", length = 1)
    private Boolean phn1Txt;

    @Column(name = "phn2ty", length = 50)
    private String phn2ty;

    @Column(name = "phn2txt", length = 1)
    private Boolean phn2txt;

    @Column(name = "scanid", length = 25)
    private String scanId;

    @Column(name = "casenum", length = 10)
    private String caseNum;

    private String fiscalYear;

    @Column(name = "ssno", length = 100)
    private String ssno;

    @Column(name = "timestamp_column", length = 8)
    private Timestamp timestampColumn;

//    @OneToOne(cascade = {CascadeType.ALL})
//    private GraduatedInformation graduatedInformation;
//
//    @OneToOne(cascade = {CascadeType.ALL})
//    private StudentYearlyData studentYearlyData;
//
//    public StudentYearlyData getStudentYearlyData() {
//        return studentYearlyData;
//    }
//
//    public void setStudentYearlyData(StudentYearlyData studentYearlyData) {
//        this.studentYearlyData = studentYearlyData;
//    }
//
//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
//    private Set<TeacherClasses> teacherClasses = new HashSet<TeacherClasses>();
//
//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
//    private Set<CounselorClasses> counselorClasses = new HashSet<CounselorClasses>();
//
//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
//    private Set<StaffClasses> staffClasses = new HashSet<StaffClasses>();
//
//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
//    private Set<TutorClasses> tutorClasses = new HashSet<TutorClasses>();

    @Column(name = "is_deleted_student", length = 1)
    private boolean isDeletedStudent;

    public Student() {
    }

    public boolean isDeletedStudent() {
        return isDeletedStudent;
    }

    public void setDeletedStudent(boolean deletedStudent) {
        isDeletedStudent = deletedStudent;
    }

//    public void assignTeacherClasses(TeacherClasses teacherClass) {
//        this.teacherClasses.add(teacherClass);
//        teacherClass.getStudentList().add(this);
//    }
//
//    public void removeTeacherClasses(TeacherClasses teacherClass) {
//        this.teacherClasses.remove(teacherClass);
//        teacherClass.getStudentList().remove(this);
//    }
//
//    public void assignCounselorClasses(CounselorClasses CounselorClass) {
//        this.counselorClasses.add(CounselorClass);
//        CounselorClass.getStudentList().add(this);
//    }
//
//    public void removeCounselorClasses(CounselorClasses CounselorClass) {
//        this.counselorClasses.remove(CounselorClass);
//        CounselorClass.getStudentList().remove(this);
//    }
//
//    public void assignStaffClasses(StaffClasses StaffClass) {
//        this.staffClasses.add(StaffClass);
//        StaffClass.getStudentList().add(this);
//    }
//
//    public void removeStaffClasses(StaffClasses StaffClass) {
//        this.staffClasses.remove(StaffClass);
//        StaffClass.getStudentList().remove(this);
//    }
//
//    public void assignTutorClasses(TutorClasses tutorClass) {
//        this.tutorClasses.add(tutorClass);
//        tutorClass.getStudentList().add(this);
//    }
//
//    public void removeTutorClasses(TutorClasses tutorClass) {
//        this.tutorClasses.remove(tutorClass);
//        tutorClass.getStudentList().remove(this);
//    }

    public long getStuid() {
        return stuid;
    }

    public void setStuid(long stuid) {
        this.stuid = stuid;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
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

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public Timestamp getTermiDate() {
        return termiDate;
    }

    public void setTermiDate(Timestamp termiDate) {
        this.termiDate = termiDate;
    }

    public Timestamp getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    public String getCollegedt() {
        return collegedt;
    }

    public void setCollegedt(String collegedt) {
        this.collegedt = collegedt;
    }

    public Integer getEthnic() {
        return ethnic;
    }

    public void setEthnic(Integer ethnic) {
        this.ethnic = ethnic;
    }

    public String getEthnicType() {
        return ethnicType;
    }

    public void setEthnicType(String ethnicType) {
        this.ethnicType = ethnicType;
    }

    public Integer getEligibilit() {
        return eligibilit;
    }

    public void setEligibilit(Integer eligibilit) {
        this.eligibilit = eligibilit;
    }

    public String getEligType() {
        return eligType;
    }

    public void setEligType(String eligType) {
        this.eligType = eligType;
    }

    public Integer getFamilySize() {
        return familySize;
    }

    public void setFamilySize(Integer familySize) {
        this.familySize = familySize;
    }

    public Integer getYearco() {
        return yearco;
    }

    public void setYearco(Integer yearco) {
        this.yearco = yearco;
    }

    public Float getGender() {
        return gender;
    }

    public void setGender(Float gender) {
        this.gender = gender;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public Integer getAcadNeed() {
        return acadNeed;
    }

    public void setAcadNeed(Integer acadNeed) {
        this.acadNeed = acadNeed;
    }

    public Integer getEnterLevel() {
        return enterLevel;
    }

    public void setEnterLevel(Integer enterLevel) {
        this.enterLevel = enterLevel;
    }

    public Integer getGpaScale() {
        return gpaScale;
    }

    public void setGpaScale(Integer gpaScale) {
        this.gpaScale = gpaScale;
    }

    public Integer getEnterExam() {
        return enterExam;
    }

    public void setEnterExam(Integer enterExam) {
        this.enterExam = enterExam;
    }

    public Integer getSatComb() {
        return satComb;
    }

    public void setSatComb(Integer satComb) {
        this.satComb = satComb;
    }

    public Integer getSatVerb() {
        return satVerb;
    }

    public void setSatVerb(Integer satVerb) {
        this.satVerb = satVerb;
    }

    public Integer getSatMath() {
        return satMath;
    }

    public void setSatMath(Integer satMath) {
        this.satMath = satMath;
    }

    public Integer getActComp() {
        return actComp;
    }

    public void setActComp(Integer actComp) {
        this.actComp = actComp;
    }

    public Integer getFinaidrecd() {
        return finaidrecd;
    }

    public void setFinaidrecd(Integer finaidrecd) {
        this.finaidrecd = finaidrecd;
    }

    public Integer getHighDegree() {
        return highDegree;
    }

    public void setHighDegree(Integer highDegree) {
        this.highDegree = highDegree;
    }

    public Integer getVenterlev() {
        return venterlev;
    }

    public void setVenterlev(Integer venterlev) {
        this.venterlev = venterlev;
    }

    public Integer getVenterJob() {
        return venterJob;
    }

    public void setVenterJob(Integer venterJob) {
        this.venterJob = venterJob;
    }

    public Integer getvDisabled() {
        return vDisabled;
    }

    public void setvDisabled(Integer vDisabled) {
        this.vDisabled = vDisabled;
    }

    public Integer getvFinaidrec() {
        return vFinaidrec;
    }

    public void setvFinaidrec(Integer vFinaidrec) {
        this.vFinaidrec = vFinaidrec;
    }

    public String getReferedBy() {
        return referedBy;
    }

    public void setReferedBy(String referedBy) {
        this.referedBy = referedBy;
    }

    public String getIncomeLev() {
        return incomeLev;
    }

    public void setIncomeLev(String incomeLev) {
        this.incomeLev = incomeLev;
    }

    public Boolean getCitizen() {
        return citizen;
    }

    public void setCitizen(Boolean citizen) {
        this.citizen = citizen;
    }

    public String getAliennum() {
        return aliennum;
    }

    public void setAliennum(String aliennum) {
        this.aliennum = aliennum;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getHealthName() {
        return healthName;
    }

    public void setHealthName(String healthName) {
        this.healthName = healthName;
    }

    public String getHealthNum() {
        return healthNum;
    }

    public void setHealthNum(String healthNum) {
        this.healthNum = healthNum;
    }

    public String getMedicaid() {
        return medicaid;
    }

    public void setMedicaid(String medicaid) {
        this.medicaid = medicaid;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocPhone() {
        return docPhone;
    }

    public void setDocPhone(String docPhone) {
        this.docPhone = docPhone;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getDlState() {
        return dlState;
    }

    public void setDlState(String dlState) {
        this.dlState = dlState;
    }

    public String getTrioName() {
        return trioName;
    }

    public void setTrioName(String trioName) {
        this.trioName = trioName;
    }

    public Integer getMarrStatus() {
        return marrStatus;
    }

    public void setMarrStatus(Integer marrStatus) {
        this.marrStatus = marrStatus;
    }

    public Boolean getCalgpa() {
        return calgpa;
    }

    public void setCalgpa(Boolean calgpa) {
        this.calgpa = calgpa;
    }

    public Float getPhrsatTemp() {
        return phrsatTemp;
    }

    public void setPhrsatTemp(Float phrsatTemp) {
        this.phrsatTemp = phrsatTemp;
    }

    public Float getPhrsComp() {
        return phrsComp;
    }

    public void setPhrsComp(Float phrsComp) {
        this.phrsComp = phrsComp;
    }

    public Float getPhrsgpa() {
        return phrsgpa;
    }

    public void setPhrsgpa(Float phrsgpa) {
        this.phrsgpa = phrsgpa;
    }

    public Float getPgpa() {
        return pgpa;
    }

    public void setPgpa(Float pgpa) {
        this.pgpa = pgpa;
    }

    public Float getPgpaPoints() {
        return pgpaPoints;
    }

    public void setPgpaPoints(Float pgpaPoints) {
        this.pgpaPoints = pgpaPoints;
    }

    public Float getHrsatTemp() {
        return hrsatTemp;
    }

    public void setHrsatTemp(Float hrsatTemp) {
        this.hrsatTemp = hrsatTemp;
    }

    public Float getHrscomp() {
        return hrscomp;
    }

    public void setHrscomp(Float hrscomp) {
        this.hrscomp = hrscomp;
    }

    public Float getHrsgpa() {
        return hrsgpa;
    }

    public void setHrsgpa(Float hrsgpa) {
        this.hrsgpa = hrsgpa;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public Float getGpaPoints() {
        return gpaPoints;
    }

    public void setGpaPoints(Float gpaPoints) {
        this.gpaPoints = gpaPoints;
    }

    public Timestamp getLastModify() {
        return lastModify;
    }

    public void setLastModify(Timestamp lastModify) {
        this.lastModify = lastModify;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public String getSchoolEnd() {
        return schoolEnd;
    }

    public void setSchoolEnd(String schoolEnd) {
        this.schoolEnd = schoolEnd;
    }

    public String getCollegendd() {
        return collegendd;
    }

    public void setCollegendd(String collegendd) {
        this.collegendd = collegendd;
    }

    public Integer getYearProj() {
        return yearProj;
    }

    public void setYearProj(Integer yearProj) {
        this.yearProj = yearProj;
    }

    public Integer getAcadneed2() {
        return acadneed2;
    }

    public void setAcadneed2(Integer acadneed2) {
        this.acadneed2 = acadneed2;
    }

    public Timestamp getEgradDate() {
        return egradDate;
    }

    public void setEgradDate(Timestamp egradDate) {
        this.egradDate = egradDate;
    }

    public Timestamp getGradDate() {
        return gradDate;
    }

    public void setGradDate(Timestamp gradDate) {
        this.gradDate = gradDate;
    }

    public Integer getMsgpaScale() {
        return msgpaScale;
    }

    public void setMsgpaScale(Integer msgpaScale) {
        this.msgpaScale = msgpaScale;
    }

    public Float getMsgpa() {
        return msgpa;
    }

    public void setMsgpa(Float msgpa) {
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

    public Integer getStateTest() {
        return stateTest;
    }

    public void setStateTest(Integer stateTest) {
        this.stateTest = stateTest;
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

    public Timestamp getDegreeDate() {
        return degreeDate;
    }

    public void setDegreeDate(Timestamp degreeDate) {
        this.degreeDate = degreeDate;
    }

    public Integer getSatWriting() {
        return satWriting;
    }

    public void setSatWriting(Integer satWriting) {
        this.satWriting = satWriting;
    }

    public Timestamp getFirstserdt() {
        return firstserdt;
    }

    public void setFirstserdt(Timestamp firstserdt) {
        this.firstserdt = firstserdt;
    }

    public Integer getCohortYear() {
        return cohortYear;
    }

    public void setCohortYear(Integer cohortYear) {
        this.cohortYear = cohortYear;
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

    public String getMainuId() {
        return mainuId;
    }

    public void setMainuId(String mainuId) {
        this.mainuId = mainuId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getEnterenrol() {
        return enterenrol;
    }

    public void setEnterenrol(Integer enterenrol) {
        this.enterenrol = enterenrol;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public Integer getTrackYear() {
        return trackYear;
    }

    public void setTrackYear(Integer trackYear) {
        this.trackYear = trackYear;
    }

    public Integer getRandomId() {
        return randomId;
    }

    public void setRandomId(Integer randomId) {
        this.randomId = randomId;
    }

    public Integer getAtrstdTest() {
        return atrstdTest;
    }

    public void setAtrstdTest(Integer atrstdTest) {
        this.atrstdTest = atrstdTest;
    }

    public Integer getAtrlowgpa() {
        return atrlowgpa;
    }

    public void setAtrlowgpa(Integer atrlowgpa) {
        this.atrlowgpa = atrlowgpa;
    }

    public Integer getAtrAlgebra() {
        return atrAlgebra;
    }

    public void setAtrAlgebra(Integer atrAlgebra) {
        this.atrAlgebra = atrAlgebra;
    }

    public Integer getDisconnect() {
        return disconnect;
    }

    public void setDisconnect(Integer disconnect) {
        this.disconnect = disconnect;
    }

    public Integer getCollcohort() {
        return collcohort;
    }

    public void setCollcohort(Integer collcohort) {
        this.collcohort = collcohort;
    }

    public Integer getCommcoll() {
        return commcoll;
    }

    public void setCommcoll(Integer commcoll) {
        this.commcoll = commcoll;
    }

    public Integer getMcstem() {
        return mcstem;
    }

    public void setMcstem(Integer mcstem) {
        this.mcstem = mcstem;
    }

    public Integer getbDegree() {
        return bDegree;
    }

    public void setbDegree(Integer bDegree) {
        this.bDegree = bDegree;
    }

    public String getbDegreedt() {
        return bDegreedt;
    }

    public void setbDegreedt(String bDegreedt) {
        this.bDegreedt = bDegreedt;
    }

    public Integer getbDegreeco() {
        return bDegreeco;
    }

    public void setbDegreeco(Integer bDegreeco) {
        this.bDegreeco = bDegreeco;
    }

    public String getdDegreema() {
        return dDegreema;
    }

    public void setdDegreema(String dDegreema) {
        this.dDegreema = dDegreema;
    }

    public Integer getGradadm() {
        return gradadm;
    }

    public void setGradadm(Integer gradadm) {
        this.gradadm = gradadm;
    }

    public String getGradenRodt() {
        return gradenRodt;
    }

    public void setGradenRodt(String gradenRodt) {
        this.gradenRodt = gradenRodt;
    }

    public String getGradcoll() {
        return gradcoll;
    }

    public void setGradcoll(String gradcoll) {
        this.gradcoll = gradcoll;
    }

    public Integer getgDegree() {
        return gDegree;
    }

    public void setgDegree(Integer gDegree) {
        this.gDegree = gDegree;
    }

    public String getgDegreedt() {
        return gDegreedt;
    }

    public void setgDegreedt(String gDegreedt) {
        this.gDegreedt = gDegreedt;
    }

    public String getGdoccoll() {
        return gdoccoll;
    }

    public void setGdoccoll(String gdoccoll) {
        this.gdoccoll = gdoccoll;
    }

    public Integer getDocEmploy() {
        return docEmploy;
    }

    public void setDocEmploy(Integer docEmploy) {
        this.docEmploy = docEmploy;
    }

    public Integer getAtrSchool() {
        return atrSchool;
    }

    public void setAtrSchool(Integer atrSchool) {
        this.atrSchool = atrSchool;
    }

    public String getSiteLocate() {
        return siteLocate;
    }

    public void setSiteLocate(String siteLocate) {
        this.siteLocate = siteLocate;
    }

    public String getPhn1ty() {
        return phn1ty;
    }

    public void setPhn1ty(String phn1ty) {
        this.phn1ty = phn1ty;
    }

    public Boolean getPhn1Txt() {
        return phn1Txt;
    }

    public void setPhn1Txt(Boolean phn1Txt) {
        this.phn1Txt = phn1Txt;
    }

    public String getPhn2ty() {
        return phn2ty;
    }

    public void setPhn2ty(String phn2ty) {
        this.phn2ty = phn2ty;
    }

    public Boolean getPhn2txt() {
        return phn2txt;
    }

    public void setPhn2txt(Boolean phn2txt) {
        this.phn2txt = phn2txt;
    }

    public String getScanId() {
        return scanId;
    }

    public void setScanId(String scanId) {
        this.scanId = scanId;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
        this.ssno = ssno;
    }

    public Timestamp getTimestampColumn() {
        return timestampColumn;
    }

    public void setTimestampColumn(Timestamp timestampColumn) {
        this.timestampColumn = timestampColumn;
    }

//    public GraduatedInformation getGraduatedInformation() {
//        return graduatedInformation;
//    }
//
//    public void setGraduatedInformation(GraduatedInformation graduatedInformation) {
//        this.graduatedInformation = graduatedInformation;
//    }
//
//    public Set<TeacherClasses> getTeacherClasses() {
//        return teacherClasses;
//    }
//
//    public void setTeacherClasses(Set<TeacherClasses> teacherClasses) {
//        this.teacherClasses = teacherClasses;
//    }
//
//    public Set<CounselorClasses> getCounselorClasses() {
//        return counselorClasses;
//    }
//
//    public void setCounselorClasses(Set<CounselorClasses> counselorClasses) {
//        this.counselorClasses = counselorClasses;
//    }
//
//    public Set<StaffClasses> getStaffClasses() {
//        return staffClasses;
//    }
//
//    public void setStaffClasses(Set<StaffClasses> staffClasses) {
//        this.staffClasses = staffClasses;
//    }
//
//    public Set<TutorClasses> getTutorClasses() {
//        return tutorClasses;
//    }
//
//    public void setTutorClasses(Set<TutorClasses> tutorClasses) {
//        this.tutorClasses = tutorClasses;
//    }
}
