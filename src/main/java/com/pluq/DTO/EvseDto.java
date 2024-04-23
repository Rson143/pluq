package com.pluq.DTO;

import java.util.List;

import lombok.Data;

@Data
public class EvseDto {

    private String uid;
  
    private String evse_id;
    
    private String physical_reference;
    
    private int sessionCountPerSocket;
    
    private double kWhPerSocket;
    
    private List<SessionDto> kWhPerSession;
    
    private double kWhPerDayPerSocket;
	
}
