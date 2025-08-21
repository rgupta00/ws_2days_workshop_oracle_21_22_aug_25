package com.calapp;

import com.demo.client.Calculator;
import com.demo.client.CalculatorService;

public class ClientClass {
	public static void main(String[] args) {
		
		CalculatorService calculatorService=new CalculatorService();
		Calculator calculator=calculatorService.getCalculatorPort();
		System.out.println(calculator.add(2, 1));
		
	}

}
