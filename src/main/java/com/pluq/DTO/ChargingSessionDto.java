package com.pluq.DTO;

import java.util.List;

import lombok.Data;

@Data
public class ChargingSessionDto {
	
	private String locationName;
	
	private int chargingSockets;
	
	private int sessionCount;

	private double totalKwhCharged;
		
	private List<EvseDto> evseDto;
	
}
