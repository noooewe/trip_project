package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class MemberDTO {
        private Long id;
        private String memberAccount;  //사용자 계정
        private String memberPassword; //사용자 비밀번호
        private String memberName;     //사용자 이름
        private String memberGender;   //사용자 성별
        private String memberMobile;   //사용자 핸드폰번호
        private int memberBirthYear;   //사용자 생일(년)
        private int memberBirthMonth;  //시용자 생일(월)
        private int memberBirthDay;    //사용자 생일(일)
        private String memberAddress;   //사용자 집주소
        private String memberEmailFront; //사용자 이메일(앞부분)
        private String memberDomain;   //사용자 이메일(도메인)
        private String memberHint;     //사용자 힌트 -> 추후 잃어버린 계정을 찾기 위한 값
        private String memberPassportNum; //사용자 여권번호
        private List<PassengerDTO> passengers; //추가 탑승객 정보
        private int mileage;           //사용자 마일리지


        public LocalDate getBirthDate() {
            return LocalDate.of(memberBirthYear, memberBirthMonth, memberBirthDay); }

        public String getEmail() {
            return memberEmailFront + "@" + memberDomain; }


}
