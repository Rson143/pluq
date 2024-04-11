package com.pluq.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluq.model.Location;
import com.pluq.repository.LocationsRepository;

@Service
public class LocationsServiceImpl implements LocationService {
	
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

	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	public Optional<Location> getLocationByID(@NonNull String id) {
		return locationRepository.findById(id);
	}

	public void saveLocation(List<Location> locations) {
		// TODO Auto-generated method stub
		
	}
}
