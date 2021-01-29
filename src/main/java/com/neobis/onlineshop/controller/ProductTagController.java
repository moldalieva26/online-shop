package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.ProductTagEntity;
import com.neobis.onlineshop.service.ProductTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Rename vars in model class
@RestController
@RequestMapping("/producttags")
public class ProductTagController {
	@Autowired
	public ProductTagService productTagService;
	
	@GetMapping
	public List<ProductTagEntity> getAllProductTags() {
		return productTagService.getAllTags(); 
		
	}
	
	@GetMapping("/{id}")
	public ProductTagEntity getProductTag(@PathVariable Long id) {
		return productTagService.getTagById(id);
	}
	
	@PostMapping
	public ProductTagEntity createProductTag(@RequestBody ProductTagEntity tag) { // does not work
		return productTagService.createTag(tag);
		
	}
	
	@PutMapping("/{id}")
	public ProductTagEntity updateProductTag(@PathVariable Long id, @RequestBody ProductTagEntity newTag) { // does not work
		return productTagService.updateTag(id, newTag);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteProductTag(@PathVariable Long id) {
		productTagService.deleteTag(id);
	}
	

}
