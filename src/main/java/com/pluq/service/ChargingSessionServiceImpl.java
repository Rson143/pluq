package com.pluq.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluq.DTO.ChargingSessionDto;
import com.pluq.DTO.EvseDto;
import com.pluq.DTO.SessionDto;
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
            	totalKwhCharged += getTotalKwh(chargingSession);
          	   	totalKwhPerSocket += totalKwhCharged / chargingSockets;
            	totalKwhPerSession += totalKwhCharged / totalSessions;
             }         	
                     
            ChargingSession report = new ChargingSession();
            report.setLocationName(locationName);
            report.setSocketCount(chargingSockets);
            report.setTotalKwhCharged(totalKwhCharged);
            report.setSessionCount(totalSessions);
            report.setKwhPerSocket(totalKwhPerSocket);
            report.setKwhPerSession(totalKwhPerSession);
            chargingReports.add(report);
            }
       
        return chargingReports;
    }
    
    private double getTotalKwh(List<MeterValues> chargingSession) {
    	
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

	public List<ChargingSessionDto> generateDetailChargingReport() {
		
		List<Location> locations = locationRepository.findAll();        

        List<ChargingSessionDto> chargingReports = new ArrayList<>();
        for (Location location : locations) {
        	ChargingSessionDto chargingSessionDto = new ChargingSessionDto();
        	
        	int totalSessions = 0;
        	double totalKwhCharged = 0;
        	
        	chargingSessionDto.setLocationName(location.getName());
        	chargingSessionDto.setChargingSockets(location.getEvses().size());
        	List<EvseDto> eDto = new ArrayList<>();
        	for (EVSE evse : location.getEvses()) {
        		List<MeterValues> chargingSession = meterValueRepository.findByPhysicalReference(evse.getUid());
        		
        		Map<String, List<MeterValues>> groupByTransactionId = chargingSession.stream()
        				.collect(Collectors.groupingBy(MeterValues::getTransactionId));
        		
        		totalSessions += groupByTransactionId.size();
        		totalKwhCharged += getTotalKwh(chargingSession);
        		
        		EvseDto evseDto = new EvseDto();
        		evseDto.setEvse_id(evse.getEvse_id());
        		evseDto.setUid(evse.getUid());
        		evseDto.setPhysical_reference(evse.getPhysical_reference());
        		evseDto.setSessionCountPerSocket(groupByTransactionId.size());
        		evseDto.setKWhPerSocket(getTotalKwh(chargingSession));
        		
        		//Calculating amount of KWh charged per session
        		
        		List<SessionDto> sDto =  new ArrayList<>();
        		groupByTransactionId.forEach((key, meterValueList) -> {
        			SessionDto sessionDto = new SessionDto();
        			sessionDto.setTransactionId(key);
        		    double minValue = Double.POSITIVE_INFINITY;
        		    double maxValue = Double.NEGATIVE_INFINITY;
        		
        		    for (MeterValues meterValues : meterValueList) {
        		        double value = meterValues.getMeterValue();
        		        minValue = Math.min(minValue, value);
        		        maxValue = Math.max(maxValue, value);
        		    }
        		    sessionDto.setTotalKwh(maxValue-minValue);
        			sDto.add(sessionDto);
   				});
				evseDto.setKWhPerSession(sDto);
        		        		
        		eDto.add(evseDto);
        	}
        	chargingSessionDto.setEvseDto(eDto);
        	chargingSessionDto.setSessionCount(totalSessions);
        	chargingSessionDto.setTotalKwhCharged(totalKwhCharged);
        	
        	chargingReports.add(chargingSessionDto);
        }
        return chargingReports;
	}
}
