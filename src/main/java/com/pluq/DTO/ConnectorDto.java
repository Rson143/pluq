package com.pluq.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ConnectorDto {

	    private Long connector_id;

	    private String id;

	    private String standard;

	    private String format;

	    private String power_type;

	    private int voltage;

	    private int amperage;
	    
	    private LocalDateTime last_updated;

	    private String tariff_id;
}
