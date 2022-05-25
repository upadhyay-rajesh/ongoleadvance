package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CartTempRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.model.CartItemModel;
import com.example.model.CartModel;
import com.example.model.CartTempModel;
import com.example.model.ProductModel;

@RestController
@CrossOrigin(origins = "*")
public class CartController {
	
	@Autowired
	ProductService productRepo;
	
	@Autowired
	CartTempRepo cartRepo;
	
	@PostMapping("/home/{id}")
	public void addToCart(@RequestBody String Quantity,@PathVariable String id) {
		ProductModel p = productRepo.getproduct(id);
		CartTempModel cart = new CartTempModel();
		String[] arr = Quantity.split(" ");
		cart.setQuantity(Integer.parseInt(arr[0]));
		cart.setUserId(arr[1]);
		cart.setProductName(p.getProductName());
		cart.setPrice(p.getPrice());
		cartRepo.save(cart);
	}
	
	@PostMapping("/home/dup/{id}")
	public void addToCartByName(@RequestBody String Quantity,@PathVariable String id) {
		ProductModel p = productRepo.getproductByName(id);
		CartTempModel cart = new CartTempModel();
		String[] arr = Quantity.split(" ");
		cart.setQuantity(Integer.parseInt(arr[0]));
		cart.setUserId(arr[1]);
		cart.setProductName(p.getProductName());
		cart.setPrice(p.getPrice());
		cartRepo.save(cart);
	}
	
	@GetMapping("/cart/{id}")
	public List<CartTempModel> showCart(@PathVariable String id){
		return (List<CartTempModel>) cartRepo.findByUserId(id);
	}
	
	@PostMapping("/cart/delete")
	public void deleteCartItem(@RequestBody String id) {
		System.out.println(id);
		cartRepo.deleteById(id);
	}
}
