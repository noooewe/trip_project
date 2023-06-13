package com.portfolio.trip_project.entity;

import com.portfolio.trip_project.dto.MemberDTO;
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
    private String memberUserName;

    @Column(length = 20, nullable = false)
    private String memberPassword;

    @Column(length = 20, nullable = false)
    private String memberName;

    @Column(length = 10, nullable = false )
    private String memberGender;

    @Column(length = 10, nullable = false)
    private String memberCountryCode;

    @Column(length = 10, nullable = false)
    private String memberTelecom;

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

    @Column(length = 20, nullable = false)
    private String memberHint;

    @Column(length = 30, unique = true, nullable = false)
    private String memberPassportNum;

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberUserName(memberDTO.getMemberUserName());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberGender(memberDTO.getMemberGender());
        memberEntity.setMemberCountryCode(memberDTO.getMemberCountryCode());

        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        memberEntity.setMemberBirthYear(memberDTO.getMemberBirthYear());
        memberEntity.setMemberBirthMonth(memberDTO.getMemberBirthMonth());
        memberEntity.setMemberBirthDay(memberDTO.getMemberBirthDay());
        memberEntity.setMemberAddress(memberDTO.getMemberAddress());
        memberEntity.setMemberEmailFront(memberDTO.getMemberEmailFront());
        memberEntity.setMemberDomain(memberDTO.getMemberDomain());
        memberEntity.setMemberHint(memberDTO.getMemberHint());
        memberEntity.setMemberPassportNum(memberDTO.getMemberPassportNum());
        return memberEntity;

    }

}