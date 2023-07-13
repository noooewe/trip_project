package com.portfolio.trip_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.portfolio.trip_project.entity.FlightBookingEntity;
import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity, Long> {

    @Query("SELECT f FROM FlightBookingEntity f WHERE f.airLine.departureAirport = :departureAirport AND f.airLine.arrivalAirport = :arrivalAirport AND f.departureDate = :departureDate AND f.arrivalDate = :arrivalDate AND f.airLine.seatPositionClass = :seatPositionClass AND f.airLine.seatPositionClassPrice = :seatPositionClassPrice AND f.airLine.airlineMealType = :airlineMealType AND f.airLine.airlineMealPrice = :airlineMealPrice AND f.airLine.baggageWeight = :baggageWeight AND f.airLine.baggageWeightPrice = :baggageWeightPrice")
    List<FlightBookingEntity> findAvailableFlights(
            @Param("departureAirport") String departureAirport,
            @Param("arrivalAirport") String arrivalAirport,
            @Param("departureDate") String departureDate,
            @Param("arrivalDate") String arrivalDate,
            @Param("seatPositionClass") String seatPositionClass,
            @Param("seatPositionClassPrice") Integer seatPositionClassPrice,
            @Param("airlineMealType") String airlineMealType,
            @Param("airlineMealPrice") Integer airlineMealPrice,
            @Param("baggageWeight") String baggageWeight,
            @Param("baggageWeightPrice") Integer baggageWeightPrice
    );
}