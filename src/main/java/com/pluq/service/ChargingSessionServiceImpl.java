package com.pluq.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluq.model.ChargingSession;
import com.pluq.model.EVSE;
import com.pluq.model.Location;
import com.pluq.model.MeterValues;
import com.pluq.repository.LocationsRepository;
import com.pluq.repository.MeterValueRepository;

@Service
public class ChargingSessionServiceImpl {

	@Autowired
	private LocationsRepository locationRepository;
	
	@Autowired
    private MeterValueRepository meterValueRepository;
	
    public List<ChargingSession> generateChargingReport() {
        List<Location> locations = locationRepository.findAll();        

        List<ChargingSession> chargingReports = new ArrayList<>();
        for (Location location : locations) {
        	String locationName= location.getName();
            int chargingSockets = location.getEvses().size();
            int totalSessions = 0;
            double totalKwhCharged = 0;
            double totalKwhPerSocket = 0;
            double totalKwhPerSession = 0;
            for (EVSE evse : location.getEvses()) {
            	List<MeterValues> chargingSession = meterValueRepository.findByPhysicalReference(evse.getUid());
            	totalSessions += chargingSession.size();
            	totalKwhCharged += getTotalKwh(chargingSession, totalKwhCharged);
          	   	totalKwhPerSocket += totalKwhCharged / chargingSockets;
            	totalKwhPerSession += totalKwhCharged / totalSessions;
             }         	
                     
            ChargingSession report = new ChargingSession();
            report.setLocation(locationName);
            report.setSocketCount(chargingSockets);
            report.setTotalKwhCharged(totalKwhCharged);
            report.setSessionCount(totalSessions);
            report.setKwhPerSocket(totalKwhPerSocket);
            report.setKwhPerSession(totalKwhPerSession);
            chargingReports.add(report);
            }
       
        return chargingReports;

}
    
    private double getTotalKwh(List<MeterValues> chargingSession, double totalKwhCharged) {
    	
    	if (chargingSession != null) {
        	MeterValues minValue = chargingSession.stream()
        			.min(Comparator.comparingDouble(MeterValues::getMeterValue))
        					.orElse(new MeterValues());
    	
        	MeterValues maxValue = chargingSession.stream()
        			.max(Comparator.comparingDouble(MeterValues::getMeterValue))
        					.orElse(new MeterValues());
        	return maxValue.getMeterValue() - minValue.getMeterValue();
        	}
    	return 0;
    }
}
