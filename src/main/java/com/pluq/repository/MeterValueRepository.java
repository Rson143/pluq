package com.pluq.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluq.model.MeterValues;

public interface MeterValueRepository extends JpaRepository<MeterValues , Long> {

	List<MeterValues> findByPhysicalReference(String physicalReference);
}
