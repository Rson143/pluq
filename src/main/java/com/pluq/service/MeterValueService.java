package com.pluq.service;

import java.util.List;

import com.pluq.DTO.MeterValueDto;

public interface MeterValueService {
	
	List<MeterValueDto> findByPhysicalReference(String physicalReference);

}
