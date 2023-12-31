package com.portfolio.trip_project.dto;

import com.portfolio.trip_project.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class MemberDTO {
        private Long id;
        private String memberUserName;  //사용자 계정
        private String memberPassword; //사용자 비밀번호
        private String memberPasswordCheck; //사용자 비밀번호재확인
        private String memberName;     //사용자 이름
        private String memberGender;   //사용자 성별
        private String memberCountryCode; //사용자 국가코드번호
        private String memberTelecom; //사용자 통신사
        private String memberMobile;   //사용자 핸드폰번호
        private String memberMobileFull;  //사용자 전체 핸드폰번호
        private String memberBirthYear;   //사용자 생일(년)
        private String memberBirthMonth;  //시용자 생일(월)
        private String memberBirthDay;    //사용자 생일(일)
        private String memberBirthDate; //사용자 생년월일
        private String memberPostcode; //사용자 우편번호
        private String memberAddress;   //사용자 주소
        private String memberDetailAddress; //사용자 상세주소
        private String memberExtraAddress; //사용자 주소 참고항목
        private String memberAddressFull; //사용자 주소 전체
        private String memberEmailFront; //사용자 이메일(앞부분)
        private String memberDomain;   //사용자 이메일(도메인)
        private String memberEmailFull; //사용자 이메일 전체
        private String memberHint;     //사용자 힌트 -> 추후 잃어버린 계정을 찾기 위한 값
        private String memberPassportNum; //사용자 여권번호
        private String memberSms;
        private String memberEmailMarketing;
        private List<PassengerDTO> passengers; //추가 탑승객 정보
        private int mileage;           //사용자 마일리지

        public static MemberDTO toDTO(MemberEntity memberEntity) {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setId(memberEntity.getId());
                memberDTO.setMemberUserName(memberEntity.getMemberUserName());
                memberDTO.setMemberPassword(memberEntity.getMemberPassword());
                memberDTO.setMemberPasswordCheck(memberEntity.getMemberPasswordCheck());
                memberDTO.setMemberName(memberEntity.getMemberName());
                memberDTO.setMemberGender(memberEntity.getMemberGender());
                memberDTO.setMemberCountryCode(memberEntity.getMemberCountryCode());
                memberDTO.setMemberTelecom(memberEntity.getMemberTelecom());
                memberDTO.setMemberMobile(memberEntity.getMemberMobile());
                memberDTO.setMemberBirthYear(memberEntity.getMemberBirthYear());
                memberDTO.setMemberBirthMonth(memberEntity.getMemberBirthMonth());
                memberDTO.setMemberBirthDay(memberEntity.getMemberBirthDay());
                memberDTO.setMemberPostcode(memberEntity.getMemberPostcode());
                memberDTO.setMemberAddress(memberEntity.getMemberAddress());
                memberDTO.setMemberDetailAddress(memberEntity.getMemberDetailAddress());
                memberDTO.setMemberExtraAddress(memberEntity.getMemberExtraAddress());
                memberDTO.setMemberEmailFront(memberEntity.getMemberEmailFront());
                memberDTO.setMemberDomain(memberEntity.getMemberDomain());
                memberDTO.setMemberHint(memberEntity.getMemberHint());
                memberDTO.setMemberPassportNum(memberEntity.getMemberPassportNum());
                memberDTO.setMemberSms(memberEntity.getMemberSms());
                memberDTO.setMemberEmailMarketing(memberEntity.getMemberEmailMarketing());
                memberDTO.setMemberMobileFull(memberEntity.getMemberTelecom() + "" + memberEntity.getMemberCountryCode() + "-" + memberEntity.getMemberMobile());
                memberDTO.setMemberBirthDate(memberEntity.getMemberBirthYear() + "." +  memberEntity.getMemberBirthMonth() + "." + memberEntity.getMemberBirthDay());
                memberDTO.setMemberEmailFull(memberEntity.getMemberEmailFront() + "@" + memberEntity.getMemberDomain());
                memberDTO.setMemberAddressFull(memberEntity.getMemberAddress() + " " + memberEntity.getMemberDetailAddress());

                return memberDTO;

        }

}
