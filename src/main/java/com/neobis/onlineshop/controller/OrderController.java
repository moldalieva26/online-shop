package com.neobis.onlineshop.controller;

import com.neobis.onlineshop.entity.OrderEntity;
import com.neobis.onlineshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// NOT WORKING
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	@GetMapping
	public List<OrderEntity> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public OrderEntity getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
	//order.country // select orders where country == X from  join order and customer tables
		// "SELECT o.id, o.customer_id, c.country from  customer_order o INNER JOIN on o.customer_id = c.id customer c WHERE c.country=='USA'"
		
	@GetMapping(path="/{country}")
	public OrderEntity getOrderByCustomerCountry(@PathVariable String country) {
		return orderService.getOrderByCustomerCountry(country);
	}
	
	@PostMapping
	public OrderEntity createOrder(OrderEntity order) { // cannot create, customer_id cannot be put and does not have defaulte value
		return orderService.createOrder(order);
	}

	
	@PutMapping("/{id}")
	public OrderEntity updateOrder(@PathVariable Long id, OrderEntity newOrder) {
		return orderService.updateOrder(id, newOrder);
	}
	//delete?
	
}
