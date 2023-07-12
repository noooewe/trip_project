package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FlightBookingDTO {

    private MemberDTO memberDTO;            // 예약자 정보
    private AirLineDTO airLineDTO;          // 항공 정보

    // 추가 탑승객
    private List<PassengerDTO> addPassengers;

    // 예약 추가 정보
    private String departureDate; // 출발일
    private String arrivalDate;   // 도착일
    private String addMeal;     // 기내식 추가 여부
    private String addMealType;  // 추가 기내식 메뉴 선택
    private String addBaggage;   // 추가 수화물 여부
    private String addBaggageType; // 추가 수화물 무게 선택

    public static FlightBookingDTO createFromMemberAndAirLine(MemberDTO memberDTO, AirLineDTO airLineDTO, List<PassengerDTO> passengers) {
        FlightBookingDTO flightBookingDTO = new FlightBookingDTO();

        // 예약자 정보 설정
        flightBookingDTO.setMemberDTO(memberDTO);
        // 항공편 정보 설정
        flightBookingDTO.setAirLineDTO(airLineDTO);
        // 추가 탑승객 정보 설정
        flightBookingDTO.setAddPassengers(passengers);

        return flightBookingDTO;
    }
}