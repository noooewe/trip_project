package com.portfolio.trip_project.repository;

import com.portfolio.trip_project.entity.AirLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirLineRepository extends JpaRepository<AirLineEntity, Long> {

}