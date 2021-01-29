package com.neobis.onlineshop.entity;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class CartEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne()
	@JoinColumn(name="customer_id") //??
	private CustomerEntity customerId;

	
	
	public CartEntity() {

	}



	public CartEntity(Long id, CustomerEntity customerId) {
		super();
		this.id = id;
		this.customerId = customerId;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public CustomerEntity getCustomerId() {
		return customerId;
	}



	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}
	
	
	

	

}
