package com.pluq.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Embeddable
@Data
public class Coordinates {
   
	@JsonProperty("latitude")
    private String latitude;
    
    @JsonProperty("longitude")
    private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
}
