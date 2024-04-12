package com.pluq.service;

import java.util.ArrayList;
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
public class ChargingSessionServiceImpl implements ChargingSessionService {

	@Autowired
	private LocationsRepository locationRepository;
	
	@Autowired
    private MeterValueRepository meterValueRepository;
	
//	@Autowired
//	private ChargingSessionRepository chargingSessionRepository;

    public List<ChargingSession> generateChargingReport() {
        List<Location> locations = locationRepository.findAll();
        List<MeterValues> chargingSession = meterValueRepository.findAll();
        

        List<ChargingSession> chargingReports = new ArrayList<>();
        for (Location location : locations) {
        	String locationName= location.getName();
            int chargingSockets = location.getEvses().size();

            int totalSessions = 0;
            double totalKwhCharged = 0;
            double totalKwhPerSocket = 0;
            double totalKwhPerSession = 0;
            for (EVSE evse : location.getEvses()) {
            	totalSessions += meterValueRepository.findByPhysicalReference(evse.getUid()).size();   
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
        System.out.println(chargingSession.size());
       
        return chargingReports;
    }

	@Override
	public List<Location> getLocationNames(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
