package com.example.spring.transaction.demo.utils;

import java.util.HashMap;
import java.util.Map;

import com.example.spring.transaction.demo.exception.InsufficientFundException;

public class PaymentUtils {
	
	private static Map<String, Double> paymentInfoMap = new HashMap<String, Double>();
	
	static {
		
		paymentInfoMap.put("acc1", 10000.0);
		paymentInfoMap.put("acc2", 20000.0);
		paymentInfoMap.put("acc3", 40000.0);
		paymentInfoMap.put("acc4", 30000.0);
	}
	
	public static boolean validateCreditLimit(String accountNo, double amount) {
		
		double currentBankAmount = paymentInfoMap.get(accountNo);
		System.out.println(currentBankAmount+" "+amount);
		 if(currentBankAmount<amount) { 
			 throw new InsufficientFundException("Insufficient balance in account");
		 }else{
			 return true;
			}
		 }
		  
	}
	


