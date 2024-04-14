package com.pluq.model;

public class ChargingSession {
	
	private String locationName;

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
