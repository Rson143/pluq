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
import com.pluq.model.EnergyPrices;
import com.pluq.repository.EnergyPricesRepository;

@Service
public class EnergyPricesService {
	
	@Autowired
	private EnergyPricesRepository energyPricesRepository;
	
	@SuppressWarnings("null")
	public void loadEneryPricesFromJson(String filePath) throws IOException {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            List<EnergyPrices> energyPrices = objectMapper.readValue(jsonData, new TypeReference<List<EnergyPrices>>() {});
            energyPricesRepository.saveAll(energyPrices);

        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
