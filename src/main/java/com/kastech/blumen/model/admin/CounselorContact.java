package com.kastech.blumen.model.admin;

public class CounselorContact {

	private Integer id;
	private String firstName;
	private String lastName;
	private String phone;
	private String contactDate;
	private String counselor;
	private String contactTime;
	private String reContactDate;

	public CounselorContact(Integer id, String firstName, String lastName, String phone, String contactDate,
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

}
