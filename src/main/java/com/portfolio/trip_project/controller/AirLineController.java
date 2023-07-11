package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.AirLineDTO;
import com.portfolio.trip_project.service.AirLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/airline")
public class AirLineController {

    private final AirLineService airLineService;

    @GetMapping("/save")
    private String saveForm() {
        return "adminPages/AdminAirLineSave";
    }

    @PostMapping("/save")
    private String save(@ModelAttribute AirLineDTO airLineDTO) {
        airLineService.save(airLineDTO);
        return "adminPages/AdminIndex";
    }

}