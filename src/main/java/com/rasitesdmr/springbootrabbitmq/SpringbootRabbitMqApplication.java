package com.rasitesdmr.springbootrabbitmq;

import com.rasitesdmr.springbootrabbitmq.model.Notification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringbootRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitMqApplication.class, args);

	}

}
