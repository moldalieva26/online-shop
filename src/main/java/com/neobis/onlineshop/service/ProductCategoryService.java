package com.neobis.onlineshop.service;


import com.neobis.onlineshop.entity.ProductCategoryEntity;
import com.neobis.onlineshop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	public List<ProductCategoryEntity> getAllProductCategories() {
		return productCategoryRepository.findAll();
	}

	public ProductCategoryEntity getProductCategory(Long id) {
		return productCategoryRepository.findById(id).get();
	}

	public void deleteProductCategory(Long id) {
		// TODO Auto-generated method stub
		productCategoryRepository.deleteById(id);
		
	}

	public ProductCategoryEntity createProductCategory(ProductCategoryEntity productCategory) {
		// TODO Auto-generated method stub
		return productCategoryRepository.save(productCategory);
	}

}
