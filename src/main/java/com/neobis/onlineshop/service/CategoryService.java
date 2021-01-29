package com.neobis.onlineshop.service;


import com.neobis.onlineshop.entity.CategoryEntity;
import com.neobis.onlineshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	@Autowired
	public CategoryRepository categoryRepository;

	public List<CategoryEntity> getAllCategories() {
		return categoryRepository.findAll();
	}

	public CategoryEntity getCategoryById(Long id) {
		return categoryRepository.findById(id).get();
	}

	public CategoryEntity createCategory(CategoryEntity category) {
		return categoryRepository.save(category); 
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

	public CategoryEntity updateCategory(Long id, CategoryEntity newCategory) { 
		if(categoryRepository.findById(id).isPresent()) {
			CategoryEntity category = categoryRepository.findById(id).get();
			category.setCategoryName(newCategory.getCategoryName());
			category.setSubCategoryName(newCategory.getSubCategoryName());
			return categoryRepository.save(category);
			
		}
		return null;
		
	}

}
