package com.pluq.service;

import java.util.List;

import com.pluq.DTO.MeterValueDTO;

public interface MeterValueService {
	
	List<MeterValueDTO> findByPhysicalReference(String physicalReference);

}
