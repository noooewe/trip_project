package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AirLineDTO {

    private Long id;
    private String airlineName;             //항공사 이름
    private String airplaneNumber;          //항공기 번호
    private double baseFare;                //항공사 기본 요금
    private boolean operatesDomestic;       //국내 노선 운영 여부
    private boolean operatesInternational;  //국제 노선 운영 여부
    private Long flightBookingId;


}
