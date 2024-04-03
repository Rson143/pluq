package com.pluq.model;


import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
public class MeterValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @Column(name = "physical_reference")
    private String physicalReference;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "meter_value")
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
    
    
}