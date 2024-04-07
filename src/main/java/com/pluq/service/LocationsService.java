package com.pluq.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluq.model.Location;
import com.pluq.repository.LocationsRepository;

@Service
public class LocationsService {
	
	@Autowired
	private LocationsRepository locationRepository;
	
	@SuppressWarnings("null")
	public void loadLocationsFromJson(String filePath) throws IOException {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            List<Location> meterValue = objectMapper.readValue(jsonData, new TypeReference<List<Location>>() {});
            locationRepository.saveAll(meterValue);

        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
