package com.kastech.blumen.model.student.dataentry;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "graduated_information", schema = "blumen2")
public class GraduatedInformation {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="graduated_information_list_seq_gen")
    @SequenceGenerator(name="graduated_information_list_seq_gen", sequenceName="GRADUATED_INFORMATION_LIST_SEQ")
    private Long ssno;
    private String firstName;
    private String lastName;
    private String track;
    private String graduated;
    private String counselor;
    private String phone1;
    private String major;
    private String employer;

    private String degreeIn;
    private String titleOrPosition;
    private String militaryType;
    private String graduatedEducationStatus;
    private String employmentType;
    private String graduatedYear;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressNotes addressNotes;

    public GraduatedInformation() {
    }

    public GraduatedInformation(Long ssno,String firstName, String lastName, String track, String graduated, String counselor, String phone1, String major, String employer, String degreeIn, String titleOrPosition, String militaryType, String graduatedEducationStatus, String employmentType, String graduatedYear, AddressNotes addressNotes) {
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.track = track;
        this.graduated = graduated;
        this.counselor = counselor;
        this.phone1 = phone1;
        this.major = major;
        this.employer = employer;
        this.degreeIn = degreeIn;
        this.titleOrPosition = titleOrPosition;
        this.militaryType = militaryType;
        this.graduatedEducationStatus = graduatedEducationStatus;
        this.employmentType = employmentType;
        this.graduatedYear = graduatedYear;
        this.addressNotes = addressNotes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getDegreeIn() {
        return degreeIn;
    }

    public void setDegreeIn(String degreeIn) {
        this.degreeIn = degreeIn;
    }

    public String getTitleOrPosition() {
        return titleOrPosition;
    }

    public void setTitleOrPosition(String titleOrPosition) {
        this.titleOrPosition = titleOrPosition;
    }

    public String getMilitaryType() {
        return militaryType;
    }

    public void setMilitaryType(String militaryType) {
        this.militaryType = militaryType;
    }

    public String getGraduatedEducationStatus() {
        return graduatedEducationStatus;
    }

    public void setGraduatedEducationStatus(String graduatedEducationStatus) {
        this.graduatedEducationStatus = graduatedEducationStatus;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getGraduatedYear() {
        return graduatedYear;
    }

    public void setGraduatedYear(String graduatedYear) {
        this.graduatedYear = graduatedYear;
    }

    public AddressNotes getAddressNotes() {
        return addressNotes;
    }

    public void setAddressNotes(AddressNotes addressNotes) {
        this.addressNotes = addressNotes;
    }

    public Long getSsno() {
        return ssno;
    }

    public void setSsno(Long ssno) {
        this.ssno = ssno;
    }

    @Override
    public String toString() {
        return "GraduatedInformation{" +
                "ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", track='" + track + '\'' +
                ", graduated='" + graduated + '\'' +
                ", counselor='" + counselor + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", major='" + major + '\'' +
                ", employer='" + employer + '\'' +
                ", degreeIn='" + degreeIn + '\'' +
                ", titleOrPosition='" + titleOrPosition + '\'' +
                ", militaryType='" + militaryType + '\'' +
                ", graduatedEducationStatus='" + graduatedEducationStatus + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", graduatedYear='" + graduatedYear + '\'' +
                ", addressNotes=" + addressNotes +
                '}';
    }


    public GraduatedInformation updateWith(GraduatedInformation item) {
        return new GraduatedInformation(
                this.ssno,
                item.firstName,
                item.lastName,
                item.track,
                item.graduated,
                item.counselor,
                item.phone1,
                item.major,
                item.employer,
                item.degreeIn,
                item.titleOrPosition,
                item.militaryType,
                item.graduatedEducationStatus,
                item.employmentType,
                item.graduatedYear,
                item.addressNotes
        );
    }
}
