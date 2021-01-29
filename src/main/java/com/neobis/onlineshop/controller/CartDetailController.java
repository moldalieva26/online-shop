package com.neobis.onlineshop.controller;

import com.neobis.onlineshop.entity.CartDetailEntity;
import com.neobis.onlineshop.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cartdetails")
public class CartDetailController {
	@Autowired
	CartDetailService cartDetailService;
	
	@GetMapping("/{id}")
	public CartDetailEntity getCartById(@PathVariable Long id) {
		return cartDetailService.getCartById(id);
	}
	
	@GetMapping
	public List<CartDetailEntity> getAllCartDetails(){
		return cartDetailService.getAllCartDetails();
	}
	
	@PostMapping
    //org.hibernate.PropertyValueException: not-null property references a null or transient value : com.furnitureshop.app.v1.entity.CartDetail.cartId
	public CartDetailEntity createCartDetail(CartDetailEntity cartDetail) { // postman: Column 'cart_id' cannot be null. mysql works
		return cartDetailService.createCartDetail(cartDetail);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCartDetail(@PathVariable Long id) {
		cartDetailService.deleteCartDetail(id);
	}
	
	@PutMapping("/{id}")
	public void updateCartDetail(@PathVariable Long id, CartDetailEntity newCartDetail) {
		cartDetailService.updateCartDetail(id, newCartDetail);
	}
	

}
