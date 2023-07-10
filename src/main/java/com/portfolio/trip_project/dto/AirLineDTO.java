package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AirLineDTO {

    private Long id;
    private String IATACode;             //IATACode
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

}
