package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.model.Inventory;
import com.example.repository.InventoryRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository ir) {
		return args->{
			Inventory i=new Inventory();
			i.setSkuCode("iphone_13");
			i.setQuantity(100);
			Inventory i1=new Inventory();
			i.setSkuCode("iphone_13_red");
			i.setQuantity(0);
			
			ir.save(i);
			ir.save(i1);
		};
	}

}
