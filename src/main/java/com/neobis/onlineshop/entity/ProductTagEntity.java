package com.neobis.onlineshop.entity;

import javax.persistence.*;
// change the var names

@Entity
@Table(name="product_tag")
public class ProductTagEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity productId;
	
	@ManyToOne
	@JoinColumn(name="tag_id")
	private ProductTagEntity tagId;
	
	public ProductTagEntity() {
		
	}

	public ProductTagEntity(Long id, ProductEntity productId, ProductTagEntity tagId) {
		super();
		this.id = id;
		this.productId = productId;
		this.tagId = tagId;
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

	public ProductTagEntity getTagId() {
		return tagId;
	}

	public void setTagId(ProductTagEntity tagId) {
		this.tagId = tagId;
	}
	



}
