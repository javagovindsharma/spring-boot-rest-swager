package com.techprimers.service;

import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techprimers.model.Products;
import com.techprimers.repository.ProductsRepository;


@Service
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductsRepository productRepository;

	public List<Products> getAllUsers(){  
		logger.info("All Product with services modules");
        List<Products> userRecords = new ArrayList<>();  
        userRecords= productRepository.findAll();
        return userRecords;  
    }

	public Products getUser(String id) {
		return productRepository.findOne(id);
	}

	public void addUser(Products userRecord) {
		productRepository.save(userRecord);
	}

	public void delete(String id) {
		productRepository.delete(id);
	}
	
	public void updateProduct(Products product) {
		productRepository.setNewDescriptionForProduct(product.getProductCode(),product.getProductName(),product.getProductLine(),product.getProductScale(),product.getProductVendor(),product.getProductDescription(),product.getQuantityInStock(),product.getBuyPrice(),product.getMSRP());
	}
	
	
}


