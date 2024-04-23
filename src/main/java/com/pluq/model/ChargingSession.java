package com.pluq.model;

import lombok.Data;

@Data
public class ChargingSession {
	
	private String locationName;

    private int socketCount;

    private double totalKwhCharged;

    private int sessionCount;

    private double kwhPerSocket;

    private double kwhPerSession;

    private double kwhPerDayPerSocket;
        	
}
