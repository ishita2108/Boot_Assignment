package com.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value="v2") 
@Primary
@Lazy
public class Car implements Vehicle {
	public void move() {
		System.out.println("Car is Moving");
	}
}
