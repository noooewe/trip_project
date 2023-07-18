package com.portfolio.trip_project.dto;

import com.portfolio.trip_project.entity.AirLineEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class AirLineDTO {

    private Long id;
    private String departureAirport;     //출발공항
    private String arrivalAirport;       //도착공항
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime departureTime;        //출발시간
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime arrivalTime;          //도착시간
    private int flightTime;           //비행시간
    private String airPlane;             //항공기 이름
    private int baseFare;                //기본 요금
    private String operatesDomestic;       //국내 노선 운영 여부
    private String operatesInternational;  //국제 노선 운영 여부
    private String seatPositionClass;      //Class 종류
    private int seatPositionClassPrice;    //Class 별 가격
    private String airlineMealType;        //기내식 종류
    private int airlineMealPrice;       //기내식 가격
    private String baggageWeight;          //수화물 무게
    private int baggageWeightPrice;     //수화물 가격
    private Long flightBookingId;

    public static AirLineDTO AirLinetoDTO(AirLineEntity airLineEntity) {
        AirLineDTO airLineDTO = new AirLineDTO();
        airLineDTO.setId(airLineEntity.getId());
        airLineDTO.setDepartureAirport(airLineEntity.getDepartureAirport());
        airLineDTO.setArrivalAirport(airLineEntity.getArrivalAirport());
        airLineDTO.setDepartureTime(airLineEntity.getDepartureTime());
        airLineDTO.setArrivalTime(airLineEntity.getArrivalTime());
        airLineDTO.setFlightTime(airLineEntity.getFlightTime());
        airLineDTO.setAirPlane(airLineEntity.getAirPlane());
        airLineDTO.setBaseFare(airLineEntity.getBaseFare());
        airLineDTO.setOperatesDomestic(airLineEntity.getOperatesDomestic());
        airLineDTO.setOperatesInternational(airLineEntity.getOperatesInternational());
        airLineDTO.setSeatPositionClass(airLineEntity.getSeatPositionClass());
        airLineDTO.setSeatPositionClassPrice(airLineEntity.getSeatPositionClassPrice());
        airLineDTO.setAirlineMealType(airLineEntity.getAirlineMealType());
        airLineDTO.setAirlineMealPrice(airLineEntity.getAirlineMealPrice());
        airLineDTO.setBaggageWeight(airLineEntity.getBaggageWeight());
        airLineDTO.setBaggageWeightPrice(airLineEntity.getBaggageWeightPrice());

        return airLineDTO;
    }

}
