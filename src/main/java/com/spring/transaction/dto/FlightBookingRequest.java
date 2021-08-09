package com.spring.transaction.dto;

import com.spring.transaction.entity.PassengerInfo;
import com.spring.transaction.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;
}
