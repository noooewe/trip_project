package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PassengerDTO {

        private Long id;
        private String passengerName;         // 추가 탑승객 이름
        private String passengerGender;       // 추가 탑승객 성별
        private String passengerBirth;        // 추가 탑승객 생년월일
        private String passengerPassportNum;  // 추가 탑승객 여권번호
        private Long memberId;

}
