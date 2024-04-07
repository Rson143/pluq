package com.pluq.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
class EVSE {
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
    @JoinColumn(name = "evse_id")
    @JsonProperty("connectors")
    private List<Connector> connectors;

}
