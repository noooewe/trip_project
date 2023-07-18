package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.FlightSearchDTO;
import com.portfolio.trip_project.service.FlightBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/flightBooking")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    @PostMapping("/flightBooking")
    public ResponseEntity<?> processFlightSearch(@RequestBody FlightSearchDTO flightSearchDTO) {
        boolean flightExists = flightBookingService.checkFlight(flightSearchDTO);
        if (flightExists) {
            flightBookingService.tempStoreFlightSearch(flightSearchDTO);
            return ResponseEntity.ok().build(); // HTTP 200 OK
        } else {
            return ResponseEntity.badRequest().body("Flight does not exist"); // HTTP 400 Bad Request
        }
    }
}