package com.pluq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pluq.service.EnergyPricesServiceImpl;
import com.pluq.service.LocationsServiceImpl;
import com.pluq.service.MeterValueServiceImpl;

@Component
public class DataLoaderComponent implements CommandLineRunner{
	
	@Autowired
	MeterValueServiceImpl meterValueServiceImpl;
	
	@Autowired
	EnergyPricesServiceImpl eneryPricesServicImpl;
	
	@Autowired
	LocationsServiceImpl locationsServiceImpl;
	
    @Override
    public void run(String... args) throws Exception {
		meterValueServiceImpl.loadMeterValueFromJson("src/main/resources/meterValues.json");
		eneryPricesServicImpl.loadEneryPricesFromJson("src/main/resources/energyPrices.json");
		locationsServiceImpl.loadLocationsFromJson("src/main/resources/locations.json");
		
    }
}