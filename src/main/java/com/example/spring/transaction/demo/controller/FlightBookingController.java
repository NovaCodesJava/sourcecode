package com.example.spring.transaction.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.transaction.demo.dto.FlightBookingAcknowledgement;
import com.example.spring.transaction.demo.dto.FlightBookingRequest;
import com.example.spring.transaction.demo.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightBookingController {
	
	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping("/bookFlight")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest) {
		
		return flightBookingService.bookFlightTicket(flightBookingRequest);
		
	}

}
