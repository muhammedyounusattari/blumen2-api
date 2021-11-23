package com.kastech.blumen.model.student;

import java.util.List;

public class Asset {

	private Integer id;
	private String type;
	private String description;
	private String inStock;
	private String make;
	private String serialNumber;
	private String model;
	private String status;
	private String purDate;
	private String purPrice;
	private String loanDate;
	private String checkOutTo;
	private String dueDate;
	private String notes;
	private String lastInventoriedBy;
	private String lastInventoriedDate;
	private String lastLoanedTo;
	private String lastLoanedDate;
	private String lastReturnedBy;
	private String lastReturnedDate;
	private List<CheckInAssest> checkInAssestList;
	private List<CheckOutAssest> checkOutAssestList;

	public Asset(Integer id, String type, String description, String inStock, String make, String serialNumber,
			String model, String status, String purDate, String purPrice, String loanDate, String checkOutTo,
			String dueDate, String notes, String lastInventoriedBy, String lastInventoriedDate, String lastLoanedTo,
			String lastLoanedDate, String lastReturnedBy, String lastReturnedDate,
			List<CheckInAssest> checkInAssestList, List<CheckOutAssest> checkOutAssestList) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.inStock = inStock;
		this.make = make;
		this.serialNumber = serialNumber;
		this.model = model;
		this.status = status;
		this.purDate = purDate;
		this.purPrice = purPrice;
		this.loanDate = loanDate;
		this.checkOutTo = checkOutTo;
		this.dueDate = dueDate;
		this.notes = notes;
		this.lastInventoriedBy = lastInventoriedBy;
		this.lastInventoriedDate = lastInventoriedDate;
		this.lastLoanedTo = lastLoanedTo;
		this.lastLoanedDate = lastLoanedDate;
		this.lastReturnedBy = lastReturnedBy;
		this.lastReturnedDate = lastReturnedDate;
		this.checkInAssestList = checkInAssestList;
		this.checkOutAssestList = checkOutAssestList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPurDate() {
		return purDate;
	}

	public void setPurDate(String purDate) {
		this.purDate = purDate;
	}

	public String getPurPrice() {
		return purPrice;
	}

	public void setPurPrice(String purPrice) {
		this.purPrice = purPrice;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getCheckOutTo() {
		return checkOutTo;
	}

	public void setCheckOutTo(String checkOutTo) {
		this.checkOutTo = checkOutTo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLastInventoriedBy() {
		return lastInventoriedBy;
	}

	public void setLastInventoriedBy(String lastInventoriedBy) {
		this.lastInventoriedBy = lastInventoriedBy;
	}

	public String getLastInventoriedDate() {
		return lastInventoriedDate;
	}

	public void setLastInventoriedDate(String lastInventoriedDate) {
		this.lastInventoriedDate = lastInventoriedDate;
	}

	public String getLastLoanedTo() {
		return lastLoanedTo;
	}

	public void setLastLoanedTo(String lastLoanedTo) {
		this.lastLoanedTo = lastLoanedTo;
	}

	public String getLastLoanedDate() {
		return lastLoanedDate;
	}

	public void setLastLoanedDate(String lastLoanedDate) {
		this.lastLoanedDate = lastLoanedDate;
	}

	public String getLastReturnedBy() {
		return lastReturnedBy;
	}

	public void setLastReturnedBy(String lastReturnedBy) {
		this.lastReturnedBy = lastReturnedBy;
	}

	public String getLastReturnedDate() {
		return lastReturnedDate;
	}

	public void setLastReturnedDate(String lastReturnedDate) {
		this.lastReturnedDate = lastReturnedDate;
	}

	public List<CheckInAssest> getCheckInAssestList() {
		return checkInAssestList;
	}

	public void setCheckInAssestList(List<CheckInAssest> checkInAssestList) {
		this.checkInAssestList = checkInAssestList;
	}

	public List<CheckOutAssest> getCheckOutAssestList() {
		return checkOutAssestList;
	}

	public void setCheckOutAssestList(List<CheckOutAssest> checkOutAssestList) {
		this.checkOutAssestList = checkOutAssestList;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

}
