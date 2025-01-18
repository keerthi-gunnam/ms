package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;
import com.example.model.Product;
import com.example.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private  ProductRepository productRepository;
	
	
//	public ProductServiceImpl(ProductRepository productRepository) {
//		this.productRepository=productRepository;
//	}
	
	
	@Override
	public void createProduct(ProductRequest productRequest) {
		Product product=Product.builder()
						.name(productRequest.getName())
						.description(productRequest.getDescription())
						.price(productRequest.getPrice()).build();
		productRepository.save(product);
		log.info("product {} is saved",product.getId());
	}


	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> products=productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice()).build();
	}

}
