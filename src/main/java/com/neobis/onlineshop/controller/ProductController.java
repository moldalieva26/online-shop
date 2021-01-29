package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.ProductEntity;
import com.neobis.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}")
	public ProductEntity getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@GetMapping()
	public List<ProductEntity> getAllProducts(){
		return productService.getAllProducts();
	} 
	
	@GetMapping("/name/{productName}")
	public List<ProductEntity> getProductsByName(@PathVariable String productName) {
		return productService.getProductsByName(productName);
		
	}
	
	@GetMapping("/category/{categoryId}")
	public List<ProductEntity> getProductsByCategory(@PathVariable Long categoryId){
		return productService.getProductsByCategory(categoryId);
	}
	
	@PostMapping()
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity newProduct) {
		return productService.updateProduct(id, newProduct);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		 productService.deleteProduct(id);
	}
	

}
