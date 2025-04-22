package com.productcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Product;


@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

	
	List<Product> findByCategory(String category);
	List<Product> readByBrand(String brand);
	List<Product> findByPriceLessThanEqual(double price);
	
	
	
}
