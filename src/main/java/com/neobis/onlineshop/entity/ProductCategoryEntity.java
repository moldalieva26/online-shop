package com.neobis.onlineshop.entity;

import javax.persistence.*;

// incorect mapping with Category entity - product_category
@Entity
@Table(name="product_category")
public class ProductCategoryEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id; 

	@ManyToOne
	@JoinColumn(name="category_id")
	private ProductCategoryEntity categoryId;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity productId;
	
	public ProductCategoryEntity() {
		
	}

	public ProductCategoryEntity(Long id, ProductCategoryEntity categoryId, ProductEntity productId) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.productId = productId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductCategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ProductCategoryEntity categoryId) {
		this.categoryId = categoryId;
	}

	public ProductEntity getProductId() {
		return productId;
	}

	public void setProductId(ProductEntity productId) {
		this.productId = productId;
	}
	
	



	


}
