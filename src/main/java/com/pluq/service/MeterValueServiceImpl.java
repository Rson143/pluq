package com.pluq.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluq.DTO.MeterValueDto;
import com.pluq.model.MeterValues;
import com.pluq.repository.MeterValueRepository;

@Service
public class MeterValueServiceImpl implements MeterValueService {
	
	private static final Logger logger = Logger.getLogger(MeterValueServiceImpl.class.getName());
	
	@Autowired
	private MeterValueRepository meterValueRepository;

	public void loadMeterValueFromJson(String filePath) throws IOException {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            List<MeterValues> meterValue = objectMapper.readValue(jsonData, new TypeReference<List<MeterValues>>() {});
            meterValueRepository.saveAll(meterValue);
            logger.info("Meter Values data created");
        } catch (IOException e) {
        	logger.log(Level.SEVERE, "Error occurred: " + e.getMessage(), e);
        }

	}

	public List<MeterValueDto> getAllMeterValue() {
		List<MeterValues> meterValues =  meterValueRepository.findAll();
		return MeterValueMapper.toDTOList(meterValues);
	}


	@Override
	public List<MeterValueDto> findByPhysicalReference(String physicalReference) {
		List<MeterValues> meterValues = meterValueRepository.findByPhysicalReference(physicalReference);
		return MeterValueMapper.toDTOList(meterValues);
	}

	public void saveMeterValues(@NonNull List<MeterValueDto> values) 
	{
		 List<MeterValues> meterValues = MeterValueMapper.toJpaList(values);
		 logger.info("Meter value created "+meterValues.toString());
		 meterValueRepository.saveAll(meterValues);
	}
}



