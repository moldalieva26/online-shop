package com.neobis.onlineshop.service;


import com.neobis.onlineshop.entity.OrderDetailEntity;
import com.neobis.onlineshop.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;

	public List<OrderDetailEntity> getAllOrderDetails() {
		return orderDetailRepository.findAll();
	}


	public OrderDetailEntity getOrderDetailById(Long id) {
		return orderDetailRepository.findById(id).get();
	}


	public OrderDetailEntity createOrderDetail(OrderDetailEntity orderDetail) {
		return orderDetailRepository.save(orderDetail);
	}


	public void deleteOrderDetail(Long id) {
		orderDetailRepository.deleteById(id);
		
	}


	public OrderDetailEntity updateOrderDetail(Long id, OrderDetailEntity newOrderDetail) {
		if(orderDetailRepository.findById(id).isPresent()) {
			OrderDetailEntity orderDetail = orderDetailRepository.findById(id).get();
			orderDetail.setOrderId(newOrderDetail.getOrderId());
			orderDetail.setProductId(newOrderDetail.getProductId());
			orderDetail.setQuantity(newOrderDetail.getQuantity());
			orderDetail.setSubtotal(newOrderDetail.getSubtotal());
			orderDetail.setTax(newOrderDetail.getTax());
			orderDetail.setTotal(newOrderDetail.getTotal());
			return orderDetailRepository.save(orderDetail);
			
			
		}
		
		return null;
	}
}
