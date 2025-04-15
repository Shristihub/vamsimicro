package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	// derived query
	List<Product> findByFeaturesColor(String color);
	
//	native sql query
//	select * from product p inner join features f on p.features_id =f.features_id 
//	where f.color='white';
	
//	custom query
	@Query("from Product p inner join p.features f where f.color=?1  ")
	List<Product> findByColor(String color);
	
	
	
	

}
