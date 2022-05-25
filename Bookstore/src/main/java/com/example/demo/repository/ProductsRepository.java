package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ProductModel;

@Repository
public interface ProductsRepository extends JpaRepository<ProductModel, String> {

	Optional<ProductModel> findByProductName(String productName);

	void deleteByProductName(String name);
	
}
