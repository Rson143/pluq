package com.pluq.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Embeddable
@Data
public class OpeningTime {
	
	@JsonProperty("twentyfourseven")
	private Boolean twentyfourseven;
	
	public OpeningTime() {
		this.twentyfourseven = null;
	}

}
