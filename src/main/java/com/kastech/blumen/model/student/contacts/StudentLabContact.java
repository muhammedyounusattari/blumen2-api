package com.kastech.blumen.model.student.contacts;

import javax.persistence.*;

@Entity
@Table(name = "student_lab_contact", schema = "blumen2")
public class StudentLabContact {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_lab_contact_list_seq_gen")
	@SequenceGenerator(name="student_lab_contact_list_seq_gen", sequenceName="STUDENT_LAB_CONTACT_LIST_SEQ")
	private Integer id;
	private String firstName;
	private String lastName;
	private String labDate;
	private String checkIn;
	private String checkOut;
	private String reasonForVisit;

	public StudentLabContact() {
	}

	public StudentLabContact(Integer id, String firstName, String lastName, String labDate, String checkIn,
							 String checkOut, String reasonForVisit) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.labDate = labDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reasonForVisit = reasonForVisit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getLabDate() {
		return labDate;
	}

	public void setLabDate(String labDate) {
		this.labDate = labDate;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	@Override
	public String toString() {
		return "StudentLabContact{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", labDate='" + labDate + '\'' +
				", checkIn='" + checkIn + '\'' +
				", checkOut='" + checkOut + '\'' +
				", reasonForVisit='" + reasonForVisit + '\'' +
				'}';
	}
}
