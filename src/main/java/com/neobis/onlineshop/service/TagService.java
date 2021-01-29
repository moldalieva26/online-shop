package com.neobis.onlineshop.service;


import com.neobis.onlineshop.entity.TagEntity;
import com.neobis.onlineshop.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
	
	@Autowired
	TagRepository tagRepository;
	
	public List<TagEntity> getAllTags() {
		return tagRepository.findAll();
	}

	public TagEntity getTagById(Long id) {
		return tagRepository.findById(id).get();
	}

	public TagEntity updateTag(Long id, TagEntity newTag) {
		if(tagRepository.findById(id).isPresent()) {
			TagEntity tag = tagRepository.findById(id).get();
			tag.setTagName(newTag.getTagName());
			tag.setProductTagId(newTag.getProductTagId()); // cannot update productTagId
		
			return  tagRepository.save(tag); // returns null after updating???
			
			
		}
		return null;
	}

	public TagEntity createTag(TagEntity tag) {
		return tagRepository.save(tag);
	}

	public void deleteTag(Long id) {
		tagRepository.deleteById(id);
		
	}

}
