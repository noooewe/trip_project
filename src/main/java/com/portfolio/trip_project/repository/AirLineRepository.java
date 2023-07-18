package com.portfolio.trip_project.repository;

import com.portfolio.trip_project.entity.AirLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface AirLineRepository extends JpaRepository<AirLineEntity, Long> {
    Optional<AirLineEntity> findByDepartureAirportAndArrivalAirportAndSeatPositionClass(
            String departureAirport, String arrivalAirport, String seatPositionClass
    );

    List<AirLineEntity> findByDepartureAirportAndArrivalAirportAndDepartureTimeAndArrivalTime(
            String departureAirport, String arrivalAirport, LocalTime departureTime, LocalTime arrivalTime
    );
}