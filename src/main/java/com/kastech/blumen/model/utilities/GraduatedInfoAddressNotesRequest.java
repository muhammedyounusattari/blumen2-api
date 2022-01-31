package com.kastech.blumen.model.utilities;

import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;

public class GraduatedInfoAddressNotesRequest {

    private GraduatedInformation graduatedInformation;
    private AddressNotes addressNotes;
    private String ssno;
    private String studentName;

    public GraduatedInfoAddressNotesRequest() {
    }

    public GraduatedInfoAddressNotesRequest(GraduatedInformation graduatedInformation, AddressNotes addressNotes, String ssno, String studentName) {
        this.graduatedInformation = graduatedInformation;
        this.addressNotes = addressNotes;
        this.ssno = ssno;
        this.studentName = studentName;
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
        this.ssno = ssno;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public GraduatedInformation getGraduatedInformation() {
        return graduatedInformation;
    }

    public void setGraduatedInformation(GraduatedInformation graduatedInformation) {
        this.graduatedInformation = graduatedInformation;
    }

    public AddressNotes getAddressNotes() {
        return addressNotes;
    }

    public void setAddressNotes(AddressNotes addressNotes) {
        this.addressNotes = addressNotes;
    }

    @Override
    public String toString() {
        return "GraduatedInfoAddressNotesRequest{" +
                "graduatedInformation=" + graduatedInformation +
                ", addressNotes=" + addressNotes +
                ", ssno='" + ssno + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
