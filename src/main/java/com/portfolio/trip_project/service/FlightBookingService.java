package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.FlightSearchDTO;
import com.portfolio.trip_project.entity.FlightBookingEntity;
import com.portfolio.trip_project.repository.FlightBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.portfolio.trip_project.entity.FlightBookingEntity.flightBookingToDTO;

@Service
@RequiredArgsConstructor
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;
    private FlightSearchDTO flightSearchDTO;

    public boolean checkFlight(FlightSearchDTO flightSearchDTO) {
        return flightBookingRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateAndArrivalDate(
                flightSearchDTO.getDepartureAirport(),
                flightSearchDTO.getArrivalAirport(),
                flightSearchDTO.getDepartureDate(),
                flightSearchDTO.getArrivalDate()).isEmpty();
    }

    public void tempStoreFlightSearch(FlightSearchDTO flightSearchDTO) {
        this.flightSearchDTO = flightSearchDTO;
    }

    public void storeFlightBooking() {
        FlightBookingEntity flightBookingEntity = flightBookingToDTO(flightSearchDTO);
        flightBookingRepository.save(flightBookingEntity);
    }

}