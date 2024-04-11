package com.pluq.service;

import java.util.List;
import java.util.stream.Collectors;

import com.pluq.DTO.MeterValueDTO;
import com.pluq.model.MeterValues;

public class MeterValueMapper {
	
	public static MeterValueDTO toDTO(MeterValues meterValue) {
		MeterValueDTO dto = new MeterValueDTO();
		dto.setDate(meterValue.getDate());
        dto.setDateAdded(meterValue.getDateAdded());
        dto.setPhysicalReference(meterValue.getPhysicalReference());
        dto.setTransactionId(meterValue.getTransactionId());
        dto.setMeterValue(meterValue.getMeterValue());
		System.out.println(dto.toString());
        return dto;
	}
	
	 public static List<MeterValueDTO> toDTOList(List<MeterValues> meterValue) {
		 
	        return meterValue.stream().map(MeterValueMapper::toDTO).collect(Collectors.toList());
	    }

}