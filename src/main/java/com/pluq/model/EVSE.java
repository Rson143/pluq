package com.pluq.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class EVSE {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @JsonProperty("uid")
    private String uid;
    
    @JsonProperty("evse_id")
    private String evse_id;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("last_updated")
    private LocalDateTime last_updated;
    
    @ElementCollection
    @JsonProperty("capabilities")
    private List<String> capabilities;
    
    @JsonProperty("physical_reference")
    private String physical_reference;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("connectors")
    private List<Connector> connectors;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEvse_id() {
		return evse_id;
	}

	public void setEvse_id(String evse_id) {
		this.evse_id = evse_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}

	public List<String> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(List<String> capabilities) {
		this.capabilities = capabilities;
	}

	public String getPhysical_reference() {
		return physical_reference;
	}

	public void setPhysical_reference(String physical_reference) {
		this.physical_reference = physical_reference;
	}

	public List<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
	}
    
}
