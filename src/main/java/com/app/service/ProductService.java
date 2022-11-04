package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repo.ProductRepo;

@Service
public class ProductService {
    
	@Autowired
	private ProductRepo productRepo;
	
	public String insertProduct() {
		return productRepo.insertProduct();
	}
	
	
}
