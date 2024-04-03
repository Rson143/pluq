package com.pluq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluq.model.EnergyPrices;


public interface EnergyPricesRepository extends JpaRepository<EnergyPrices , Long> {

}
