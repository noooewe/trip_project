package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.AirLineDTO;
import com.portfolio.trip_project.service.AirLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public String findAll(Model model) {
        List<AirLineDTO> airLineDTOList = airLineService.findAll();
        model.addAttribute("airLineList", airLineDTOList);
        return "adminPages/AdminAirLineList";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        airLineService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}