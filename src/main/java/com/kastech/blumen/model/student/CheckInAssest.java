package com.kastech.blumen.model.student;

public class CheckInAssest {

	private Integer id;
	private Asset asset;

	private String loadDate;
	private String checkedOutTo;
	private String dueDate;
	private String changeStatusTo;
	private String notes;

	public CheckInAssest(Integer id, Asset asset, String loadDate, String checkedOutTo, String dueDate,
			String changeStatusTo, String notes) {
		super();
		this.id = id;
		this.asset = asset;
		this.loadDate = loadDate;
		this.checkedOutTo = checkedOutTo;
		this.dueDate = dueDate;
		this.changeStatusTo = changeStatusTo;
		this.notes = notes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public String getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(String loadDate) {
		this.loadDate = loadDate;
	}

	public String getCheckedOutTo() {
		return checkedOutTo;
	}

	public void setCheckedOutTo(String checkedOutTo) {
		this.checkedOutTo = checkedOutTo;
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
