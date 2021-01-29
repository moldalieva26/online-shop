package com.neobis.onlineshop.service;


import com.neobis.onlineshop.entity.CartDetailEntity;
import com.neobis.onlineshop.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService {
	@Autowired
	CartDetailRepository cartDetailRepository;

	public CartDetailEntity getCartById(Long id) {
		return cartDetailRepository.findById(id).get();
	}

	public List<CartDetailEntity> getAllCartDetails() {
		return cartDetailRepository.findAll();
	}

	public CartDetailEntity createCartDetail(CartDetailEntity cartDetail) {
		return cartDetailRepository.save(cartDetail);
	}

	public void deleteCartDetail(Long id) {
		cartDetailRepository.deleteById(id);		
	}

	public void updateCartDetail(Long id, CartDetailEntity newCartDetail) {
		if(cartDetailRepository.findById(id).isPresent()) {
			CartDetailEntity cartDetail = cartDetailRepository.findById(id).get();
			cartDetail.setQuantity(newCartDetail.getQuantity());
			cartDetail.setProductId(newCartDetail.getProductId());
		//	cartDetail.setCartId(newCartDetail.getCartId());

		}
		
	}

}
