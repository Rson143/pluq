package com.pluq.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnergyPrices {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;
    
    @Column(name = "date_id")
    private String id;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "buy_volume")
    private double buyVolume;
    
    @Column(name = "sellVolume")
    private double sellVolume;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "unit")
    private String unit;
    
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "timeslot")
    private int timeslot;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getBuyVolume() {
		return buyVolume;
	}

	public void setBuyVolume(double buyVolume) {
		this.buyVolume = buyVolume;
	}

	public double getSellVolume() {
		return sellVolume;
	}

	public void setSellVolume(double sellVolume) {
		this.sellVolume = sellVolume;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}
}
