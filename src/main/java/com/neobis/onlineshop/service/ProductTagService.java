package com.neobis.onlineshop.service;

import com.neobis.onlineshop.entity.ProductTagEntity;
import com.neobis.onlineshop.repository.ProductTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//add else, if, try catch for exceptions
@Service
public class ProductTagService {
	
	@Autowired
	ProductTagRepository productTagRepository;
	
	public List<ProductTagEntity> getAllTags() {
		return productTagRepository.findAll();
	}

	public ProductTagEntity getTagById(Long id) {
		return productTagRepository.findById(id).get();
	}

	public ProductTagEntity updateTag(Long id, ProductTagEntity newProductTag) {
		if(productTagRepository.findById(id).isPresent()) {
			ProductTagEntity existingTag = productTagRepository.findById(id).get();
			existingTag.setProductId(newProductTag.getProductId()); // cannot update or set
			existingTag.setTagId(newProductTag.getTagId());
			return  productTagRepository.save(existingTag); 
			
			
		} else {
		return null;}
	}
	
	

	public ProductTagEntity createTag(ProductTagEntity tag) {
		return productTagRepository.save(tag);
	}

	public void deleteTag(Long id) {
		productTagRepository.deleteById(id);
		
	}

}
