package com.spring.transaction.service;

import java.util.UUID;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.dto.FlightBookingAcknowledgement;
import com.spring.transaction.dto.FlightBookingRequest;
import com.spring.transaction.entity.PassengerInfo;
import com.spring.transaction.entity.PaymentInfo;
import com.spring.transaction.repository.PassengerInfoRepository;
import com.spring.transaction.repository.PaymentInfoRepository;
import com.spring.transaction.utils.PaymentUtils;

@Service
public class FlightBookingService {
	
	private static Logger logger = LoggerFactory.getLogger(FlightBookingService.class);

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		
		PassengerInfo passengerInfo = request.getPassengerInfo();		
		passengerInfo = passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
				
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getPrice());
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(paymentInfo.getAmount());
		
		paymentInfoRepository.save(paymentInfo);
		return new FlightBookingAcknowledgement("Success", passengerInfo.getPrice(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}
}
