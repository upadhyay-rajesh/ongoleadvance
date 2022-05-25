package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CartTempModel;

@Repository
public interface CartTempRepo extends CrudRepository<CartTempModel, String>{

	List<CartTempModel> findByUserId(String userid);
	
}
