package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FlightSearchDTO {
    private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String arrivalDate;
    private String seatPositionClass;
    private int seatPositionClassPrice;
    private String airlineMealType;
    private int airlineMealPrice;
    private String baggageWeight;
    private int baggageWeightPrice;
    private String addMeal;
    private String addMealType;
    private String addBaggage;
    private String addBaggageType;
    private List<PassengerDTO> addPassengers;


}
