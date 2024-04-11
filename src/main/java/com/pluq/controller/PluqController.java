package com.pluq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pluq.DTO.MeterValueDTO;
import com.pluq.model.Location;
import com.pluq.model.MeterValues;
import com.pluq.service.EnergyPricesServiceImpl;
import com.pluq.service.LocationsServiceImpl;
import com.pluq.service.MeterValueServiceImpl;
import com.pluq.util.Constant;

@RestController
@RequestMapping("/pluq")
public class PluqController {
	
	private final LocationsServiceImpl locationsServiceImpl;
	private final MeterValueServiceImpl meterValueServiceImpl;
	private final EnergyPricesServiceImpl energyPriceServiceImpl;
	
	public PluqController(LocationsServiceImpl locationsServiceImpl, MeterValueServiceImpl meterValueServiceImpl ,EnergyPricesServiceImpl energyPriceServiceImpl) {
		this.locationsServiceImpl = locationsServiceImpl;
		this.energyPriceServiceImpl = energyPriceServiceImpl;
		this.meterValueServiceImpl = meterValueServiceImpl;
		
	}
	
	//Meter value retrieving and saving
	
	@GetMapping(Constant.METER_VALUE)
	public 	List<MeterValues>  meterValue(){
		return meterValueServiceImpl.getAllMeterValue();
	}
	
	@GetMapping(Constant.METER_VALUE_BY_PHYSICAL_REFERENCE)
	public List<MeterValueDTO> meterValueByPhysicalReference(
			@PathVariable String physicalReference
			){
		try{
			return meterValueServiceImpl.findByPhysicalReference(physicalReference);
      } catch (Exception e) {
          e.printStackTrace();
          return new ArrayList<>();
        }	
	}
	
	@PostMapping(Constant.SAVE_METER_VALUES)
	public ResponseEntity<String> saveMeterValues(@RequestBody(required = true) List<MeterValues> values){
		try {
			meterValueServiceImpl.saveMeterValues(values);
			return new ResponseEntity<>("Meter value saved", HttpStatus.CREATED);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Failed to save Meter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
	

