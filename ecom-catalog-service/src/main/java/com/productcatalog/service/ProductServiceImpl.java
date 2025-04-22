package com.productcatalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productcatalog.exceptions.ProductNotFoundException;
import com.productcatalog.model.Product;
import com.productcatalog.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	private IProductRepository productRepository;

	public ProductServiceImpl(IProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		Optional<Product> productOpt = productRepository.findById(productId); // returns an optional
		return productOpt.orElseThrow(() -> new ProductNotFoundException("invalid Id"));
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> products = productRepository.findByCategory(category);
		if (products.isEmpty())
			throw new ProductNotFoundException("no products in this category");
		return products;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> products = productRepository.readByBrand(brand);
		if (products.isEmpty())
			throw new ProductNotFoundException("no products in this category");
		return products;

	}

	@Override
	public List<Product> getByLesserPrice(double price) {
		List<Product> products = productRepository.findByPriceLessThanEqual(price);
		if (products.isEmpty())
			throw new ProductNotFoundException("no products in this category");
		return products;
	}

}
