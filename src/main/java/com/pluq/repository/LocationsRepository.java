package com.pluq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluq.model.Location;

public interface LocationsRepository extends JpaRepository<Location , String> {

}
