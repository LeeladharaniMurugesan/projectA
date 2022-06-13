package com.chainsys.springproject.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
//import javax.annotation.Resource; not working
import org.springframework.stereotype.Component;

public class Car {
	@Autowired
	private Engine petrolEngine;
	@Autowired(required = false)
	private Wheel alloy;

	public Car() {
		System.out.println(" Car Object created " + hashCode());
	}

	public void start() {
		petrolEngine.start();
	}

	public void move() {
		alloy.rotate();
	}

	public void begin() {
		System.out.println("Start Annotation...");
	}

	public void stop() {
		System.out.println("Stop Annotation...");
	}

	public void print() {
		System.out.println("Print Annotation is called");
	}

}

@Component("SportsCar")
class SportsCar extends Car {
	public SportsCar() {
		System.out.println("Sports car created " + hashCode());
	}

	@Component("SuvCar")
	class SuvCar extends Car {
		public SuvCar() {
			System.out.println("Suv car created " + hashCode());
		}
	}
}
