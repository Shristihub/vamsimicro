package com.productapp.service;

import java.util.List;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {

	// crud operation
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	
	List<Product> getAll();
	Product getById(int productId) throws ProductNotFoundException;
	
	// features class
	List<Product> getByColor(String color)throws ProductNotFoundException;

	
	
	
	
	
	
	
	
	
}
