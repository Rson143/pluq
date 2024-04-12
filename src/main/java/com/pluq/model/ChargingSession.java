package com.pluq.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;


public class ChargingSession {
	
	private Long id;
	
	private String locationName;

    private LocalDateTime date;

    private int socketCount;

    private double totalKwhCharged;

    private int sessionCount;

    private double kwhPerSocket;

    private double kwhPerSession;

    private double kwhPerDayPerSocket;

	public String getLocation() {
		return locationName;
	}

	public void setLocation(String locationName) {
		this.locationName = locationName;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getSocketCount() {
		return socketCount;
	}

	public void setSocketCount(int socketCount) {
		this.socketCount = socketCount;
	}

	public double getTotalKwhCharged() {
		return totalKwhCharged;
	}

	public void setTotalKwhCharged(double totalKwhCharged) {
		this.totalKwhCharged = totalKwhCharged;
	}

	public int getSessionCount() {
		return sessionCount;
	}

	public void setSessionCount(int sessionCount) {
		this.sessionCount = sessionCount;
	}

	public double getKwhPerSocket() {
		return kwhPerSocket;
	}

	public void setKwhPerSocket(double kwhPerSocket) {
		this.kwhPerSocket = kwhPerSocket;
	}

	public double getKwhPerSession() {
		return kwhPerSession;
	}

	public void setKwhPerSession(double kwhPerSession) {
		this.kwhPerSession = kwhPerSession;
	}

	public double getKwhPerDayPerSocket() {
		return kwhPerDayPerSocket;
	}

	public void setKwhPerDayPerSocket(double kwhPerDayPerSocket) {
		this.kwhPerDayPerSocket = kwhPerDayPerSocket;
	}


        	
}
