package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.AirLineDTO;
import com.portfolio.trip_project.dto.FlightSearchDTO;
import com.portfolio.trip_project.service.AirLineService;
import com.portfolio.trip_project.service.FlightBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/flightBooking")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;
    private final AirLineService airLineService;

    @PostMapping("/flightSearch")
    public ResponseEntity<?> flightSearch(@RequestBody FlightSearchDTO flightSearchDTO) {
        //사용자 입력 데이터에 해당하는 항공편 검색
        AirLineDTO airLineDTO = airLineService.searchFlight(flightSearchDTO);

        //해당 항공편이 없는 경우, 적절한 메시지를 보냄
        if (airLineDTO == null) {
            return ResponseEntity.badRequest().body("등록되지 않은 운항정보입니다");
        }

        //해당 항공편이 있는 경우, 해당 정보를 포함한 DTO를 리턴
        return ResponseEntity.ok(flightSearchDTO);
    }
}