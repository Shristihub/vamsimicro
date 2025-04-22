package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EcomEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomEurekaRegistryApplication.class, args);
	}

}
