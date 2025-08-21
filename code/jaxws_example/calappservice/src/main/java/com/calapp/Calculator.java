package com.calapp;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class Calculator {
	
	@WebMethod
	public int add(int a, int b) {
		return a+b;
	}
}
