package com.calapp;

import com.demo.client.Calculator;
import com.demo.client.CalculatorService;

public class Main {

	public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        Calculator proxy = service.getCalculatorPort();

        int a = 22;
        int b = 33;

        System.out.println("Sum = " + proxy.sum(a, b));
        System.out.println("Multiply = " + proxy.multiply(a, b));
	}
}
