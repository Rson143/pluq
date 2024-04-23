package com.pluq.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EnergyPrices {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;
    
    @Column(name = "date_id")
    private String id;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "buy_volume")
    private String buyVolume;
    
    @Column(name = "sellVolume")
    private String sellVolume;
    
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

}
