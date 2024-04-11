package com.pluq.DTO;

import java.time.LocalDateTime;

public class MeterValueDto {
	private LocalDateTime date;
	private LocalDateTime dateAdded;
	private String physicalReference;
	private String transactionId;
	private double meterValue;
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getPhysicalReference() {
		return physicalReference;
	}
	public void setPhysicalReference(String physicalReference) {
		this.physicalReference = physicalReference;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getMeterValue() {
		return meterValue;
	}
	public void setMeterValue(double meterValue) {
		this.meterValue = meterValue;
	}
	@Override
	public String toString() {
		return "MeterValueDTO [date=" + date + ", dateAdded=" + dateAdded + ", physicalReference=" + physicalReference
				+ ", transactionId=" + transactionId + ", meterValue=" + meterValue + "]";
	}
	
}
