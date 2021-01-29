package com.neobis.onlineshop.service;


import com.neobis.onlineshop.entity.CartEntity;
import com.neobis.onlineshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
	
	@Autowired
	public CartRepository cartRepository;

	public List<CartEntity> getAllCarts() {
		return cartRepository.findAll();
	}

	public CartEntity getCartById(Long id) {
		return cartRepository.findById(id).get();
	}

	public CartEntity createCart(CartEntity cart) {
		return cartRepository.save(cart);
	}

	public void deleteCart(Long id) {
		cartRepository.deleteById(id);
	}

}
