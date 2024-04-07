package com.pluq.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Embeddable
@Data
class Coordinates {
   
	@JsonProperty("latitude")
    private String latitude;
    
    @JsonProperty("longitude")
    private String longitude;

}
