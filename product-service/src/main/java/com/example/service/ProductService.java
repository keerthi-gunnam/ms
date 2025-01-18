package com.example.service;

import java.util.List;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;

public interface ProductService {
	
	void createProduct(ProductRequest productRequest);
	List<ProductResponse> getAllProducts();
}