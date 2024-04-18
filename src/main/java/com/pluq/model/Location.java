package com.pluq.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Location {
    @Id
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("address")
    private String address;
    
    @JsonProperty("city")
    private String city;
    
    @JsonProperty("postal_code")
    private String postal_code;
    
    @JsonProperty("country")
    private String country;
    
    @JsonProperty("name")
    private String name;
    
    @Embedded
    @JsonProperty("coordinates")
    private Coordinates coordinates;
    
    @JsonProperty("charging_when_closed")
    private boolean charging_when_closed;
    
    @JsonProperty("time_zone")
    private String time_zone;
    
    @Embedded
    @JsonProperty("opening_times")
    private OpeningTime opening_times;
    
    @JsonProperty("last_updated")
    private LocalDateTime last_updated;
    
    @Embedded
    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("evses")
    private List<EVSE> evses;
    
    public Location() {
    	this.time_zone = null;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public boolean isCharging_when_closed() {
		return charging_when_closed;
	}

	public void setCharging_when_closed(boolean charging_when_closed) {
		this.charging_when_closed = charging_when_closed;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public OpeningTime getOpening_times() {
		return opening_times;
	}

	public void setOpening_times(OpeningTime opening_times) {
		this.opening_times = opening_times;
	}

	public LocalDateTime getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}

	public List<EVSE> getEvses() {
		return evses;
	}

	public void setEvses(List<EVSE> evses) {
		this.evses = evses;
	}
}
