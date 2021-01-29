package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.CartEntity;
import com.neobis.onlineshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	public CartService cartService;
	
	@GetMapping
	public List<CartEntity> getAllCarts() {
		return cartService.getAllCarts();
		
	}
	
	@GetMapping("/{id}")
	public CartEntity getCartById(@PathVariable Long id) { // shows empty value 200 ok
		return cartService.getCartById(id);
		
	}
	
	//Do I need? @PostMapping, @DeleteMapping, @UpdateMapping must be done when customer registers and deleted only when customer's aaccount is deleted
	@PostMapping
	public CartEntity createCart( @RequestBody CartEntity cart) { // cannot set customerId
		return cartService.createCart(cart);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
		
	}
	

}
