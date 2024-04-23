package com.pluq.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluq.model.Location;
import com.pluq.repository.LocationsRepository;

@Service
public class LocationsServiceImpl{
	
	private static final Logger logger = Logger.getLogger(LocationsServiceImpl.class.getName());
	
	@Autowired
	private LocationsRepository locationRepository;
		
	public void loadLocationsFromJson(String filePath) throws IOException {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            List<Location> location = objectMapper.readValue(jsonData, new TypeReference<List<Location>>() {});
            locationRepository.saveAll(location);
            logger.info("Location data created");
        } catch (IOException e) {
        	logger.log(Level.SEVERE, "Error occurred: " + e.getMessage(), e);
        }
	}

	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	public Optional<Location> getLocationByID(@NonNull String id) {
		Optional<Location> location = locationRepository.findById(id);
		logger.info("Retrieve Location data by Id "+ location.toString());
		return location;
	}

	public void saveOrUpdateLocation(@NonNull List<Location> locations) {
		locationRepository.saveAll(locations);
    }	
}