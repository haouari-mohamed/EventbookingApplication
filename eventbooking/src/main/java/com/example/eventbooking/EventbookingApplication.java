package com.example.eventbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.eventbooking")
public class EventbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventbookingApplication.class, args);
	}

}
