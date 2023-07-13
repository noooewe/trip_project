package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.FlightSearchDTO;
import com.portfolio.trip_project.service.FlightBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/flightBooking")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    @PostMapping("/flightSearch")
    public String flightSearch(FlightSearchDTO flightSearchDTO, Model model) {
        boolean isFlightAvailable = flightBookingService.checkAvailability(flightSearchDTO);
        if (!isFlightAvailable) {
            model.addAttribute("error", "등록되지 않은 운항정보입니다");
            return "errorPage"; // 이것은 실제 오류 페이지로 대체되어야 합니다.
        }
        // put flightSearch object in the session or somewhere to be used in the next page
        model.addAttribute("flightSearch", flightSearchDTO);
        return "nextPage"; // 이것은 실제 다음 페이지로 대체되어야 합니다.
    }
}