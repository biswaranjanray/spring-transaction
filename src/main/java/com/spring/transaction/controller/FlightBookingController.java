package com.spring.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.transaction.dto.FlightBookingAcknowledgement;
import com.spring.transaction.dto.FlightBookingRequest;
import com.spring.transaction.service.FlightBookingService;

@RestController
@RequestMapping("/flightBookingService/api/v1")
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return  flightBookingService.bookFlightTicket(request);
	}
}
