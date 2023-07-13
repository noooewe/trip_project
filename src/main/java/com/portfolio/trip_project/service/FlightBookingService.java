package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.FlightSearchDTO;
import com.portfolio.trip_project.entity.FlightBookingEntity;
import com.portfolio.trip_project.repository.FlightBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;

    public boolean checkAvailability(FlightSearchDTO flightSearch) {
        List<FlightBookingEntity> flightBookingEntityList = flightBookingRepository.findAvailableFlights(
                flightSearch.getDepartureAirport(),
                flightSearch.getArrivalAirport(),
                flightSearch.getDepartureDate(),
                flightSearch.getArrivalDate(),
                flightSearch.getSeatPositionClass(),
                flightSearch.getSeatPositionClassPrice(),
                flightSearch.getAirlineMealType(),
                flightSearch.getAirlineMealPrice(),
                flightSearch.getBaggageWeight(),
                flightSearch.getBaggageWeightPrice()

        );

        return !flightBookingEntityList.isEmpty();
    }

}