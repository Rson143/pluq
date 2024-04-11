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
import com.pluq.DTO.MeterValueDTO;
import com.pluq.model.MeterValues;
import com.pluq.repository.MeterValueRepository;

@Service
public class MeterValueServiceImpl implements MeterValueService {
	
	@Autowired
	private MeterValueRepository meterValueRepository;
	
	@SuppressWarnings("null")
	public void loadMeterValueFromJson(String filePath) throws IOException {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            List<MeterValues> meterValue = objectMapper.readValue(jsonData, new TypeReference<List<MeterValues>>() {});
            meterValueRepository.saveAll(meterValue);

        } catch (IOException e) {
            e.printStackTrace();
        }

	}

	public List<MeterValues> getAllMeterValue() {
		return meterValueRepository.findAll();
	}


	@Override
	public List<MeterValueDTO> findByPhysicalReference(String physicalReference) {
		List<MeterValues> meterValues = meterValueRepository.findByPhysicalReference(physicalReference);
		return MeterValueMapper.toDTOList(meterValues);
	}

	public void saveMeterValues(List<MeterValues> values) {
		meterValueRepository.saveAll(values);
		
	}
}



