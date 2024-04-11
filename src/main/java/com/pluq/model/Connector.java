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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getPower_type() {
		return power_type;
	}

	public void setPower_type(String power_type) {
		this.power_type = power_type;
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public int getAmperage() {
		return amperage;
	}

	public void setAmperage(int amperage) {
		this.amperage = amperage;
	}

	public LocalDateTime getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}

	public String getTariff_id() {
		return tariff_id;
	}

	public void setTariff_id(String tariff_id) {
		this.tariff_id = tariff_id;
	}

}
