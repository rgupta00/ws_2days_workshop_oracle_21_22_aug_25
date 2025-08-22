package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component(value="bike") //bike
@Profile("test")
public class Bike implements Vehicle{
	public void move() {
		System.out.println("moving on bike");
	}
}
