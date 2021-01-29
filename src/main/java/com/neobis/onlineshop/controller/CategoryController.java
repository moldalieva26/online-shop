package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.CategoryEntity;
import com.neobis.onlineshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
	@GetMapping
	public List<CategoryEntity> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public CategoryEntity getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping
	public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
		return categoryService.createCategory(category);
	}

	
	@PutMapping("/{id}")
	public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity newCategory) {
		return categoryService.updateCategory(id, newCategory);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		
	}

}
