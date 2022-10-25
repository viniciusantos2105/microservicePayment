package com.learning.microservicepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class  MicroservicepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicepayApplication.class, args);
	}

}
