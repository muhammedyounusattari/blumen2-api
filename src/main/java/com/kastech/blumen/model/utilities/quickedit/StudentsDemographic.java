package com.kastech.blumen.model.utilities.quickedit;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students_demographic", schema = "blumen2")
public class StudentsDemographic {

    private String ssnoMain;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone1;
    private String phone1Type;
    private String sendTextMsg;
    private String phone2;
    private String phone2Type;
    private String sendTextMsg2;
    private String siteLocation;
    private String actComposite;
    private String academicNeed;
    private String alienNumber;
    private String autoCalculateGPA;
    private String birthPlace;

    private String citizen;
    private String codes;
    private String cohortYear;
    private String collegeEntrance;
    private String completionDate;
    private String custom1;
    private String custom2;
    private String dateCompleteCollege;
    private String dateOfBirth;
    private String doctorName;
    private String doctorPhone;
    private String driverlicenceNumber;
    private String driverlicenseState;
    private String email;
    private String eligibility;
    private String eligibilityType;

    private String endSchool;
    private String enterGradeLevel;
    private String entryCollege;
    private String entryCollegeDate;
    private String entryDate;
    private String entryHsCumGPA;
    private String entryHsCumGPAScale;
    private String entrySchool;
    private String ethnic;
    private String ethnicType;
    private String familySize;
    private String financialAidReceived;
    private String gpa;
    private String gpaPoints;
    private String gender;
    private String healthName;
    private String healthNumber;
}
