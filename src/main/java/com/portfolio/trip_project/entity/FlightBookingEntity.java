package com.portfolio.trip_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "flightBooking_table")
public class FlightBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private MemberEntity member;  // 예약자 정보

    @ManyToOne
    private AirLineEntity airLine;  // 항공 정보

    @OneToMany
    private List<PassengerEntity> addPassengers;  // 추가 탑승객 정보

    @Column(length = 20, nullable = false)
    private String departureDate;  // 출발일

    @Column(length = 20, nullable = false)
    private String arrivalDate;    // 도착일

    @Column(length = 5)
    private String addMeal;        // 기내식 추가 여부

    @Column(length = 20)
    private String addMealType;    // 추가 기내식 메뉴 선택

    @Column(length = 5)
    private String addBaggage;     // 추가 수화물 여부

    @Column(length = 10)
    private String addBaggageType; // 추가 수화물 무게 선택

    // getters and setters...
}