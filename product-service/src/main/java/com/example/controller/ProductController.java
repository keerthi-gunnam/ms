package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;
import com.example.service.ProductService;


@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
		return new ResponseEntity<>("product created Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProducts(){
		List<ProductResponse> value=productService.getAllProducts();
		return new ResponseEntity<>(value,HttpStatus.OK);
	}
}
