package com.productapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
	@Column(length = 30)
	private String productName;
	@Id
	@GeneratedValue(generator = "prod_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "prod_gen",sequenceName = "product_seq",initialValue = 1)
	private Integer productId;
	@Column(name="cost") // to give a different column name
	private double price;
	
	// save child while saving parent
	// save features in features table while saving product
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="features_id") //to give a different column name
	Features features;

	public Product(String productName, double price, Features features) {
		super();
		this.productName = productName;
		this.price = price;
		this.features = features;
	}
	
	
	
	

}
