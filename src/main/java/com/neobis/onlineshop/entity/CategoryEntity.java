package com.neobis.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id; 
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="sub_category_name")
	private String subCategoryName;
	
	@OneToMany(fetch= FetchType.LAZY)
	@JoinColumn(name="product_category_id")
	//@OnDelete(action=OnDeleteAction.CASCADE)
	private List<ProductCategoryEntity> productCategoryId;
	
	public CategoryEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public List<ProductCategoryEntity> getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(List<ProductCategoryEntity> productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	
	

	
	
}
