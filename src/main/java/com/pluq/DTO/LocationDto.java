package com.pluq.DTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class LocationDto {

	private String id;

    private String type;

    private String address;

    private String city;

    private String postal_code;

    private String country;

    private String name;
    
    @Embedded
    private CoordinatesDto coordinates;

    private boolean charging_when_closed;

    private String time_zone;
    
    @Embedded
    private OpeningTimeDto opening_times;
    
    private LocalDateTime last_updated;
    
    @Embedded
    @OneToMany(cascade = CascadeType.ALL)
    private List<EvseDto> evses;

	@Override
	public String toString() {
		return "LocationDto [id=" + id + ", type=" + type + ", address=" + address + ", city=" + city + ", postal_code="
				+ postal_code + ", country=" + country + ", name=" + name + ", coordinates=" + coordinates
				+ ", charging_when_closed=" + charging_when_closed + ", time_zone=" + time_zone + ", opening_times="
				+ opening_times + ", last_updated=" + last_updated + ", evses=" + evses + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
       
}
