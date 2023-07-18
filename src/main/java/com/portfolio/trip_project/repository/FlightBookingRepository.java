package com.portfolio.trip_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.trip_project.entity.FlightBookingEntity;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity, Long> {
    List<FlightBookingEntity> findByDepartureAirportAndArrivalAirportAndDepartureDateAndArrivalDate(
            String departureAirport, String arrivalAirport, String departureDate, String arrivalDate
    );


}