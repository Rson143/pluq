package com.pluq.DTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;

public class EvseDto {

    private String uid;
  
    private String evse_id;

    private String status;

    private LocalDateTime last_updated;
    
    @ElementCollection
    private List<String> capabilities;
    
    private String physical_reference;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ConnectorDto> connectors;
	
}
