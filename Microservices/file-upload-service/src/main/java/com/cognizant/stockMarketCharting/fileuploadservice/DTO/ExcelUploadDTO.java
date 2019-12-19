package com.cognizant.stockMarketCharting.fileuploadservice.DTO;

import java.util.Date;

public class ExcelUploadDTO {
	private int noOfRecords;
	private String companyName;
	private Date minDate;
	private Date maxDate;
	public ExcelUploadDTO(){}
	public ExcelUploadDTO(int noOfRecords, String companyName, Date minDate, Date maxDate) {
		super();
		this.noOfRecords = noOfRecords;
		this.companyName = companyName;
		this.minDate = minDate;
		this.maxDate = maxDate;
	}
	public int getNoOfRecords() {
		return noOfRecords;
	}
	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getMinDate() {
		return minDate;
	}
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}
	public Date getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}
	@Override
	public String toString() {
		return "ExcelUploadDTO [noOfRecords=" + noOfRecords + ", companyName=" + companyName + ", minDate=" + minDate
				+ ", maxDate=" + maxDate + "]";
	}
	
	
}
