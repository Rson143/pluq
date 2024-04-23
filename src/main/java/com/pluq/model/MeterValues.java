package com.pluq.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
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

}