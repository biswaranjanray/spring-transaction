package com.spring.transaction.utils;

import java.util.HashMap;
import java.util.Map;

import com.spring.transaction.exception.InsufficientBalanceException;

public class PaymentUtils {

	private static Map<Integer, Double> paymentMap = new HashMap<>();
	
	static 
	{
		paymentMap.put(112233, 5000.00);
		paymentMap.put(113344, 2000.00);
		paymentMap.put(114455, 1000.00);
		paymentMap.put(115566, 10000.00);
	}
	
	public static boolean validateCreditLimit(int accountNo, double paidAmount) {
		if(paidAmount > paymentMap.get(accountNo)) {
			throw new InsufficientBalanceException("insufficient balance...");
		} else {
			return true;
		}
	}
}
