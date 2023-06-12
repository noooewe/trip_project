package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class FlightBookingDTO {

    private Long id;
    private String departureLocation;       //출발지
    private String arrivalLocation;         //도착지
    private String departureDay;            //출발일
    private String arrivalDay;              //도착일
    private String departureTime;           //출발시간
    private String arrivalTime;             //도착시간
    private String seatClass;               //좌석 클래스 선택
    private String seatPosition;            //좌석 위치
    private double seatClassSurcharge;      //좌석 클래스에 따른 추가 요금
    private boolean airlineMealRequested;   //기내식 추가 여부
    private String airlineMealSelect;       //기내식 선택
    private double mealServiceSurcharge;    //기내식 서비스 요금
    private boolean extraBaggageRequested;  //추가 수화물 요청 여부
    private int baggageCount;               //수화물의 수
    private double baggageWeight;           //수화물의 무게
    private double baggageSurcharge;        //수화물 추가 요금
    private Long memberId;
}
