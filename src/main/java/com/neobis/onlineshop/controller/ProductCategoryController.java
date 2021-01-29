package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.ProductCategoryEntity;
import com.neobis.onlineshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productcategories")
public class ProductCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;

	@GetMapping
	public List<ProductCategoryEntity> getAllProductCategories() {
		return productCategoryService.getAllProductCategories();
	}
	
	@GetMapping("/{id}")
	public ProductCategoryEntity getProductCategory(@PathVariable Long id) {
		return productCategoryService.getProductCategory(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductCategory(@PathVariable Long id) {
		productCategoryService.deleteProductCategory(id);
	}
	
	@PostMapping()
	public ProductCategoryEntity createProductCategory(@RequestBody ProductCategoryEntity productCategory) {
			return productCategoryService.createProductCategory(productCategory);
		}
	
	@PutMapping("/{id}")
	public ProductCategoryEntity updateProductCategory(@RequestBody ProductCategoryEntity newProductCategory, Long id) {
		return null; // finish!
		
	}
	
	
	
}
