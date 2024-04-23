package com.pluq.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
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
    
}
