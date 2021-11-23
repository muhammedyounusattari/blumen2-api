package com.kastech.blumen.model.student;

public class CheckOutAssest {

	private Integer id;
	private Asset asset;

	private String scanStudentId;
	private String checkedOutTo;
	private String checkedOutDate;
	private String dueDate;
	private String changeStatusTo;
	private String notes;

	public CheckOutAssest(Integer checkInId, Asset asset, String scanStudentId, String checkedOutTo,
			String checkedOutDate, String dueDate, String changeStatusTo, String notes) {
		super();
		this.id = checkInId;
		this.asset = asset;
		this.scanStudentId = scanStudentId;
		this.checkedOutTo = checkedOutTo;
		this.checkedOutDate = checkedOutDate;
		this.dueDate = dueDate;
		this.changeStatusTo = changeStatusTo;
		this.notes = notes;
	}

	public Integer getCheckInId() {
		return id;
	}

	public void setCheckInId(Integer checkInId) {
		this.id = checkInId;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public String getScanStudentId() {
		return scanStudentId;
	}

	public void setScanStudentId(String scanStudentId) {
		this.scanStudentId = scanStudentId;
	}

	public String getCheckedOutTo() {
		return checkedOutTo;
	}

	public void setCheckedOutTo(String checkedOutTo) {
		this.checkedOutTo = checkedOutTo;
	}

	public String getCheckedOutDate() {
		return checkedOutDate;
	}

	public void setCheckedOutDate(String checkedOutDate) {
		this.checkedOutDate = checkedOutDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getChangeStatusTo() {
		return changeStatusTo;
	}

	public void setChangeStatusTo(String changeStatusTo) {
		this.changeStatusTo = changeStatusTo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
