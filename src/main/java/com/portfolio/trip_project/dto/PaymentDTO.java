package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDTO {

    private Long id;
    private PaymentMethod paymentMethod;  // 결제 방식
    private double amount;  // 결제 금액
    private Long flightBookingId;

    public enum PaymentMethod {
        CASH,
        CREDIT_CARD,
        MILEAGE
    }
}
