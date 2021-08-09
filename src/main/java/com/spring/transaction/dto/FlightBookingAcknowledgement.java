package com.spring.transaction.dto;

import com.spring.transaction.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {

	private String status;
	private double totalPrice;
	private String pnrNo;
	private PassengerInfo passengerInfo;
}
