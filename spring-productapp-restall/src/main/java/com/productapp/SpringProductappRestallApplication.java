package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Features;
import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappRestallApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappRestallApplication.class, args);
	}

	// autowire service
	@Autowired
	private IProductService productService;
	
	
	@Override
	public void run(String... args) throws Exception {
		Features features  = new Features("white", "rubber");
		Product product = new Product("FootBall",2000,features);
		productService.addProduct(product);
		
		features  = new Features("white", "wool");
		product = new Product("Jacket",5000,features);
		productService.addProduct(product);
		
		features  = new Features("black", "metal");
		product = new Product("HeadPhones",12000,features);
		productService.addProduct(product);
		
		features  = new Features("black", "leather");
		product = new Product("Shoee",3000,features);
		productService.addProduct(product);
		
		//get By Color
		productService.getByColor("white").forEach(System.out::println);
		
	}
}















