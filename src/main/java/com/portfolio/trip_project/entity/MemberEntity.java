package com.portfolio.trip_project.entity;

import com.portfolio.trip_project.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    private String memberUserName;

    @Column(length = 100, nullable = false)
    private String memberPassword;

    @Column(length = 100, nullable = false)
    private String memberPasswordCheck;

    @Column(length = 20, nullable = false)
    private String memberName;

    @Column(length = 10, nullable = false)
    private String memberGender;

    @Column(length = 10, nullable = false)
    private String memberCountryCode;

    @Column(length = 10, nullable = false)
    private String memberTelecom;

    @Column(length = 20, nullable = false)
    private String memberMobile;

    @Column(nullable = false)
    private int memberBirthYear;

    @Column(nullable = false)
    private int memberBirthMonth;

    @Column(nullable = false)
    private int memberBirthDay;

    @Column(length = 10, nullable = false)
    private String memberPostcode;

    @Column(length = 50, nullable = false)
    private String memberDetailAddress;

    @Column(length = 50, nullable = false)
    private String memberExtraAddress;

    @Column(length = 50, nullable = false)
    private String memberAddress;

    @Column(length = 20, nullable = false)
    private String memberEmailFront;

    @Column(length = 20, nullable = false)
    private String memberDomain;

    @Column(length = 20, nullable = false)
    private String memberHint;

    @Column(length = 16, unique = true, nullable = false)
    private String memberPassportNum;

    @Column(length = 5, nullable = false)
    private String memberSms;

    @Column(length = 5, nullable = false)
    private String memberEmailMarketing;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "member_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberUserName(memberDTO.getMemberUserName());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberPasswordCheck(memberDTO.getMemberPasswordCheck());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberGender(memberDTO.getMemberGender());
        memberEntity.setMemberCountryCode(memberDTO.getMemberCountryCode());
        memberEntity.setMemberTelecom(memberDTO.getMemberTelecom());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        memberEntity.setMemberBirthYear(memberDTO.getMemberBirthYear());
        memberEntity.setMemberBirthMonth(memberDTO.getMemberBirthMonth());
        memberEntity.setMemberBirthDay(memberDTO.getMemberBirthDay());
        memberEntity.setMemberPostcode(memberDTO.getMemberPostcode());
        memberEntity.setMemberAddress(memberDTO.getMemberAddress());
        memberEntity.setMemberDetailAddress(memberDTO.getMemberDetailAddress());
        memberEntity.setMemberExtraAddress(memberDTO.getMemberExtraAddress());
        memberEntity.setMemberEmailFront(memberDTO.getMemberEmailFront());
        memberEntity.setMemberDomain(memberDTO.getMemberDomain());
        memberEntity.setMemberHint(memberDTO.getMemberHint());
        memberEntity.setMemberPassportNum(memberDTO.getMemberPassportNum());
        memberEntity.setMemberSms(memberDTO.getMemberSms());
        memberEntity.setMemberEmailMarketing(memberDTO.getMemberEmailMarketing());

        if (memberDTO.getRoles() != null) {
            for (String roleName : memberDTO.getRoles()) {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setName(ERole.valueOf(roleName.toUpperCase()));
                memberEntity.getRoles().add(roleEntity);
            }

        }
        return memberEntity;
    }
}
