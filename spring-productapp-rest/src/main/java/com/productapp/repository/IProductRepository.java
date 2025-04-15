package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;


@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

	//derived queries
	//getBy(propertyName  with first letter capital)
    //findBy,readBy,queryBy	
	
	List<Product> findByCategory(String category);
	List<Product> readByBrand(String brand);
	List<Product> findByPriceLessThanEqual(double price);
	
	//custom queries -any name
	// pass the entity name not the table name - JPQL
	//select * from product where brand=?1 and price=?2
	@Query("""
			from Product p where p.brand =?1
			and price< ?2
			""")
	List<Product> findByBrandPrice(String brand,double price);
	
	//select * from product where product_name like %?%
	@Query("from Product p where p.productName like ?1")
	List<Product> findByProdNameWith(String name);
	
	//native query - use proper sql query - use table name and column name
	@Query(value = "select * from product p where p.brand=?1 and p.category=?2",nativeQuery = true)
	List<Product> getByCatBrand(String brand, String category);
	
	//named query - pass the name of the named query
	@Query(name = "getProductsByPrice")
	List<Product> findByPrice(double price);

	// stored procedure
	
}
