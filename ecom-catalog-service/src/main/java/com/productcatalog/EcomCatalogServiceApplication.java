package com.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcomCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomCatalogServiceApplication.class, args);
	}

}
