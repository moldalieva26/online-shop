package com.neobis.onlineshop.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="favorite")

public class FavoriteEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id; //?
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false) // https://stackoverflow.com/questions/52656517/no-serializer-found-for-class-org-hibernate-proxy-pojo-bytebuddy-bytebuddyinterc
	@JoinColumn(name="product_id")
	private ProductEntity productId;
	
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="customer_id")
	@OnDelete(action= OnDeleteAction.CASCADE)
	private CustomerEntity customerId;

	
	public FavoriteEntity() {
		
	}

	public FavoriteEntity(Long id, ProductEntity productId, CustomerEntity customerId) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ProductEntity getProductId() {
		return productId;
	}


	public void setProductId(ProductEntity productId) {
		this.productId = productId;
	}


	public CustomerEntity getCustomerId() {
		return customerId;
	}


	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}
	
	
	
	
	
	
	
	

}
