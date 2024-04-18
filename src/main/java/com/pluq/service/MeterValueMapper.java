package com.pluq.service;

import java.util.List;
import java.util.stream.Collectors;

import com.pluq.DTO.MeterValueDto;
import com.pluq.model.MeterValues;

public class MeterValueMapper {
	
	private static MeterValueDto toDTO(MeterValues meterValue) {
		MeterValueDto dto = new MeterValueDto();
		dto.setDate(meterValue.getDate());
        dto.setDateAdded(meterValue.getDateAdded());
        dto.setPhysicalReference(meterValue.getPhysicalReference());
        dto.setTransactionId(meterValue.getTransactionId());
        dto.setMeterValue(meterValue.getMeterValue());
		System.out.println(dto.toString());
        return dto;
	}
	
	 public static List<MeterValueDto> toDTOList(List<MeterValues> meterValue) {
		 
	        return meterValue.stream().map(MeterValueMapper::toDTO).collect(Collectors.toList());
	    }

	public static List<MeterValues> toJpaList(List<MeterValueDto> values) {
		return values.stream().map(MeterValueMapper::toJpa).collect(Collectors.toList());
    }
	
	private static MeterValues toJpa(MeterValueDto meterValue) {
		MeterValues Jpa = new MeterValues();
		Jpa.setDate(meterValue.getDate());
		Jpa.setDateAdded(meterValue.getDateAdded());
		Jpa.setPhysicalReference(meterValue.getPhysicalReference());
		Jpa.setTransactionId(meterValue.getTransactionId());
		Jpa.setMeterValue(meterValue.getMeterValue());
		System.out.println(Jpa.toString());
        return Jpa;
	}

}