package com.portfolio.trip_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.portfolio.trip_project.entity.FlightBookingEntity;
import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity, Long> {

    @Query("SELECT f FROM FlightBookingEntity f WHERE f.airLine.departureAirport = :departureAirport AND f.airLine.arrivalAirport = :arrivalAirport AND f.departureDate = :departureDate")
    List<FlightBookingEntity> findAvailableFlights(@Param("departureAirport") String departureAirport, @Param("arrivalAirport") String arrivalAirport, @Param("departureDate") String departureDate);
}