package com.neobis.onlineshop.entity;

import javax.persistence.*;

@Entity
@Table(name="cart_detail")  // cart items (one cart has 1 or many items)
public class CartDetailEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id; //???
	
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="cart_id")
	private CartEntity cartId;
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity productId;
	
	@Column(name="quantity")
	private Long quantity;
	
	
	public CartDetailEntity() {
		
	}


	public CartDetailEntity(Long id, CartEntity cartId, ProductEntity productId, Long quantity) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public CartEntity getCartId() {
		return cartId;
	}


	public void setCartId(CartEntity cartId) {
		this.cartId = cartId;
	}


	public ProductEntity getProductId() {
		return productId;
	}


	public void setProductId(ProductEntity productId) {
		this.productId = productId;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
}
