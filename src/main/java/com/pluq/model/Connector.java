package com.pluq.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Connector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long connector_id;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("standard")
    private String standard;
    
    @JsonProperty("format")
    private String format;
    
    @JsonProperty("power_type")
    private String power_type;
    
    @JsonProperty("voltage")
    private int voltage;

    @JsonProperty("amperage")
    private int amperage;
    
    @JsonProperty("last_updated")
    private LocalDateTime last_updated;
    
    @JsonProperty("tariff_id")
    private String tariff_id;

}
