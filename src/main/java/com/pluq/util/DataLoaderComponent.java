package com.pluq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pluq.service.MeterValueService;

@Component
public class DataLoaderComponent implements CommandLineRunner{
	
	@Autowired
	MeterValueService meterValueService;
	

    @Override
    public void run(String... args) throws Exception {
		meterValueService.loadMeterValueFromJson("src/main/resources/meterValues.json");
    }
}
