package com.pluq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pluq.DTO.MeterValueDto;
import com.pluq.model.ChargingSession;
import com.pluq.model.Location;
import com.pluq.model.MeterValues;
import com.pluq.service.ChargingSessionServiceImpl;
import com.pluq.service.LocationsServiceImpl;
import com.pluq.service.MeterValueServiceImpl;
import com.pluq.util.Constant;

@RestController
@RequestMapping("/pluq")
public class PluqController {
	
	private final LocationsServiceImpl locationsServiceImpl;
	private final MeterValueServiceImpl meterValueServiceImpl;
	private final ChargingSessionServiceImpl chargingSessionServiceImpl;
	
	@Autowired
	public PluqController(LocationsServiceImpl locationsServiceImpl,
			MeterValueServiceImpl meterValueServiceImpl, 
			ChargingSessionServiceImpl chargingSessionServiceImpl) {
		
		this.locationsServiceImpl = locationsServiceImpl;
		this.meterValueServiceImpl = meterValueServiceImpl;
		this.chargingSessionServiceImpl = chargingSessionServiceImpl;
	}
	
	//Meter value retrieving and saving
	
	@GetMapping(Constant.METER_VALUE)
	public 	List<MeterValues>  meterValue(){
		return meterValueServiceImpl.getAllMeterValue();
	}
	
	@GetMapping(Constant.METER_VALUE_BY_PHYSICAL_REFERENCE)
	public List<MeterValueDto> meterValueByPhysicalReference(@PathVariable String physicalReference){
		try{
			return meterValueServiceImpl.findByPhysicalReference(physicalReference);
      } catch (Exception e) {
          e.printStackTrace();
          return new ArrayList<>();
        }	
	}
	
	@PostMapping(Constant.SAVE_METER_VALUES)
	public ResponseEntity<String> saveMeterValues(@RequestBody(required = true) @NonNull List<MeterValues> values){
		
		try {
			meterValueServiceImpl.saveMeterValues(values);
			return new ResponseEntity<>("Meter value saved", HttpStatus.CREATED);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Failed to save Meter", HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	//Location retrieving and saving
	
	@GetMapping(Constant.LOCATION)
	public 	List<Location> locations(){
		try {
			return locationsServiceImpl.getAllLocations();
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	@GetMapping(Constant.LOCATION_BY_ID)
		public Optional<Location> LocationById(@PathVariable @NonNull String id){
		try {
			return locationsServiceImpl.getLocationByID(id);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@PostMapping(Constant.SAVE_OR_UPDATE_LOCATION)
	public ResponseEntity<String> saveOrUpdateLocation(@RequestBody(required = true) @NonNull List<Location> location){
		
		try {
			System.out.print("Save Location");
			locationsServiceImpl.saveOrUpdateLocation(location);
			return new ResponseEntity<>("Location saved", HttpStatus.CREATED);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Failed to save Location", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Generating charging report

	@SuppressWarnings("unchecked")
	@GetMapping("/report")
    public List<ChargingSession> getChargingReport() {
    	try {
    		List<ChargingSession> report = new ArrayList<>();
        	report = chargingSessionServiceImpl.generateChargingReport();
        	return report;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return new ArrayList<>();
    	}
    	
    	
    
    }	
}
	

