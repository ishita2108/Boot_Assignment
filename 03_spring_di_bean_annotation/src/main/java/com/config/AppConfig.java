package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.demo.Bike;
import com.demo.Car;
import com.demo.Passenger;
import com.demo.Vehicle;

@Configuration
@ComponentScan(basePackages = {"com.demo"})
public class AppConfig {

	
//	<bean id="passenger"  class="com.demo.Passenger">
//	<property name ="name" value="Ishitaa"/>
//	<property name ="vehicle" ref="v"/>
//	</bean>
	@Autowired
	@Bean(name="p")
	public Passenger getPassenger(Vehicle vehicle) {
		Passenger passenger = new Passenger();
		passenger.setName("Raj");
		passenger.setVehicle(vehicle);
		return passenger;
		
	}
	@Bean
	@Primary
	@Profile("test")
	public Vehicle getCar() {
		Vehicle vehicle = new Car();
		return vehicle;
	}
	
	@Bean
	@Profile("dev")
	public Vehicle getBike() {
		Vehicle vehicle = new Bike();
		return vehicle;
	}
}
