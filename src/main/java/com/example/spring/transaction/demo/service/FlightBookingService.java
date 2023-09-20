package com.example.spring.transaction.demo.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.spring.transaction.demo.dto.FlightBookingAcknowledgement;
import com.example.spring.transaction.demo.dto.FlightBookingRequest;
import com.example.spring.transaction.demo.entity.PassengerInfo;
import com.example.spring.transaction.demo.entity.PaymentInfo;
import com.example.spring.transaction.demo.repository.PassengerInfoRepository;
import com.example.spring.transaction.demo.repository.PaymentInfoRepository;
import com.example.spring.transaction.demo.utils.PaymentUtils;

@Service
public class FlightBookingService {
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	
	@Autowired 
	private PaymentInfoRepository paymentInfoRepository;
	
	@Transactional//(readOnly = false, isolation= Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest bookingRequest) {
				
		PassengerInfo passengerInfo = bookingRequest.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);
		
			
		PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
		
		PaymentUtils.validateCreditLimit(bookingRequest.getPaymentInfo().getAccountNo(), bookingRequest.getPassengerInfo().getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfo = paymentInfoRepository.save(paymentInfo);
		
		
		return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
		
	}

}
