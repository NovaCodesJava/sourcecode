package com.example.spring.transaction.demo.dto;

import com.example.spring.transaction.demo.entity.PassengerInfo;
import com.example.spring.transaction.demo.entity.PaymentInfo;
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
