package com.portfolio.trip_project.entity;


import com.portfolio.trip_project.dto.AirLineDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "airline_table")
public class AirLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5, nullable = false)
    private String departureAirport;

    @Column(length = 5, nullable = false)
    private String arrivalAirport;

    @Column(length = 10, nullable = false)
    private String airPlane;

    @Column
    private int baseFare;

    @Column(length = 5)
    private String operatesDomestic;

    @Column(length = 5)
    private String operatesInternational;

    @Column(length = 10, nullable = false)
    private String seatPositionClass;

    @Column
    private int seatPositionClassPrice;

    @Column(length = 20, nullable = false)
    private String airlineMealType;

    @Column
    private int airlineMealPrice;

    @Column(length = 10, nullable = false)
    private String baggageWeight;

    @Column
    private int baggageWeightPrice;

    public static AirLineEntity AirLinetoSaveEntity(AirLineDTO airLineDTO) {
        AirLineEntity airLineEntity = new AirLineEntity();
        airLineEntity.setDepartureAirport(airLineDTO.getDepartureAirport());
        airLineEntity.setArrivalAirport(airLineDTO.getArrivalAirport());
        airLineEntity.setAirPlane(airLineDTO.getAirPlane());
        airLineEntity.setBaseFare(airLineDTO.getBaseFare());
        airLineEntity.setOperatesDomestic(airLineDTO.getOperatesDomestic());
        airLineEntity.setOperatesInternational(airLineDTO.getOperatesInternational());
        airLineEntity.setSeatPositionClass(airLineDTO.getSeatPositionClass());
        airLineEntity.setSeatPositionClassPrice(airLineDTO.getSeatPositionClassPrice());
        airLineEntity.setAirlineMealType(airLineDTO.getAirlineMealType());
        airLineEntity.setAirlineMealPrice(airLineDTO.getAirlineMealPrice());
        airLineEntity.setBaggageWeight(airLineDTO.getBaggageWeight());
        airLineEntity.setBaggageWeightPrice(airLineDTO.getBaggageWeightPrice());
        return airLineEntity;
    }

}
