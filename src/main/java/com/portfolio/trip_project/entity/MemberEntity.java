package com.portfolio.trip_project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String memberAccount;

    @Column(length = 20, nullable = false)
    private String memberPassword;

    @Column(length = 20, nullable = false)
    private String memberName;

    @Column(length = 10, nullable = false )
    private String memberGender;

    @Column(length = 20, nullable = false)
    private String memberMobile;

    @Column(length = 10, nullable = false)
    private int memberBirthYear;

    @Column(length = 5, nullable = false)
    private int memberBirthMonth;

    @Column(length = 5, nullable = false)
    private int memberBirthDay;

    @Column(length = 30, nullable = false)
    private String memberAddress;

    @Column(length = 20, unique = true, nullable = false)
    private String memberEmailFront;

    @Column(length = 20, nullable = false)
    private String memberDomain;

    @Column
    private String memberHint;

    @Column(length = 30, unique = true, nullable = false)
    private String memberPassportNum;


    public LocalDate getBirthDate() {
        return LocalDate.of(memberBirthYear, memberBirthMonth, memberBirthDay);
    }

    public String getEmail() {
        return memberEmailFront + "@" + memberDomain;
    }
}