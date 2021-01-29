package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.OrderDetailEntity;
import com.neobis.onlineshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {
	@Autowired
	public OrderDetailService orderDetailService;
	
	@GetMapping
	public List<OrderDetailEntity> getAllOrderDetails(){
		return orderDetailService.getAllOrderDetails();
	}
	
	
	@GetMapping("/{id}")
	public OrderDetailEntity getOrderDetailById(@PathVariable Long id) {
		return orderDetailService.getOrderDetailById(id);
	}
	
	@PostMapping
	public OrderDetailEntity createOrderDetail(@RequestBody OrderDetailEntity orderDetail) {
		return orderDetailService.createOrderDetail(orderDetail);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrderDetail(@PathVariable Long id) {
		orderDetailService.deleteOrderDetail(id);
	}
	
	@PutMapping("/{id}")
	public OrderDetailEntity updateOrderDetail(@PathVariable Long id, @RequestBody OrderDetailEntity newOrderDetail) {
		return orderDetailService.updateOrderDetail(id, newOrderDetail);
	}
	

}
