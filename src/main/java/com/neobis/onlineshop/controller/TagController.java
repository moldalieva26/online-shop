package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.TagEntity;
import com.neobis.onlineshop.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	public TagService tagService;
	
	@GetMapping
	public List<TagEntity> getTags() {
		return tagService.getAllTags(); 
		
	}
	
	@GetMapping("/{id}")
	public TagEntity getTag(@PathVariable Long id) {
		return tagService.getTagById(id);
	}
	
	@PutMapping("/{id}")
	public TagEntity updateTag(@PathVariable Long id, @RequestBody TagEntity newTag) { // working incorrectly ??? returns null
		return tagService.updateTag(id, newTag);
	}
	
	@PostMapping
	public TagEntity createTag(@RequestBody TagEntity tag) {
		return tagService.createTag(tag);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteTag(@PathVariable Long id) {
		tagService.deleteTag(id);
	}
	
	
	
	
	

}
