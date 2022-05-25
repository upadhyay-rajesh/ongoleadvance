package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CartTempRepo;
import com.example.demo.repository.OrderTempRepo;
import com.example.model.CartTempModel;
import com.example.model.OrderTemp;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OrderController {

	@Autowired
	OrderTempRepo orderRepo;
	
	@Autowired
	CartTempRepo cartRepo;
	
	@GetMapping("/admin/orders")
	public List<OrderTemp> getProducts() {
		return (List<OrderTemp>)orderRepo.findAll();
	}
	
	@PostMapping("/orders")
	public List<OrderTemp> getUserProducts(@RequestBody String id) {
		System.out.println(id);
		System.out.println(orderRepo.findByUserId(id));
		return (List<OrderTemp>)orderRepo.findByUserId(id);
	} 
	
	@PostMapping("/saveOrder")
	public void saveProduct(@RequestBody String id){
		List<CartTempModel> cart = cartRepo.findByUserId(id);
		for(int i=0;i<cart.size();i++) {
			System.out.println(cart.get(i));
			int price = Integer.parseInt(cart.get(i).getPrice());
			int quantity = cart.get(i).getQuantity();
			OrderTemp order = new OrderTemp();
			order.setProductName(cart.get(i).getProductName());
			
			order.setPrice(cart.get(i).getPrice());
			order.setQuantity(quantity);
			order.setStatus("not delivered");
			order.setTotalPrice(price*quantity + "");
			order.setUserId(cart.get(i).getUserId());
			orderRepo.save(order);
			cartRepo.deleteById(cart.get(i).getCartItemId());
		}
		System.out.println(id);
	}
	
	@PostMapping("/placeOrder")
	public void placeOrder(@RequestBody OrderTemp order) {
		int price = Integer.parseInt(order.getPrice());
		int quantity =order.getQuantity();
		order.setTotalPrice(price*quantity + "");
		orderRepo.save(order);
		System.out.println(order);
	}
	
}
