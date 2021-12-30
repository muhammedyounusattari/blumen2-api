package com.kastech.blumen.model.student.contacts;

import javax.persistence.*;

@Entity
@Table(name = "student_counselor_contacts", schema = "blumen2")
public class StudentCounselorContact {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="stu_counselor_contact_list_seq_gen")
	@SequenceGenerator(name="stu_counselor_contact_list_seq_gen", sequenceName="STUDENT_COUNSELOR_CONTACT_LIST_SEQ")
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	private String contactDate;
	private String counselor;
	private String contactTime;
	private String reContactDate;

	public StudentCounselorContact() {
	}

	public StudentCounselorContact(Long id, String firstName, String lastName, String phone, String contactDate,
								   String counselor, String contactTime, String reContactDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.contactDate = contactDate;
		this.counselor = counselor;
		this.contactTime = contactTime;
		this.reContactDate = reContactDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public String getContactTime() {
		return contactTime;
	}

	public void setContactTime(String contactTime) {
		this.contactTime = contactTime;
	}

	public String getReContactDate() {
		return reContactDate;
	}

	public void setReContactDate(String reContactDate) {
		this.reContactDate = reContactDate;
	}

	@Override
	public String toString() {
		return "StudentCounselorContact{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phone='" + phone + '\'' +
				", contactDate='" + contactDate + '\'' +
				", counselor='" + counselor + '\'' +
				", contactTime='" + contactTime + '\'' +
				", reContactDate='" + reContactDate + '\'' +
				'}';
	}


	public StudentCounselorContact updateWith(StudentCounselorContact item) {
		return new StudentCounselorContact(
				this.id,
				item.firstName,
				item.lastName,
				item.phone,
				item.contactDate,
				item.counselor,
				item.contactTime,
				item.reContactDate
		);
	}
}
