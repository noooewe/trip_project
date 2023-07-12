package com.portfolio.trip_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "passenger_table")
public class PassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String passengerName;

    @Column(length = 5)
    private String passengerGender;

    @Column(length = 20)
    private String passengerBirth;

    @Column(length = 20)
    private String passengerPassportNum;

}
