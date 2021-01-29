package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.FavoriteEntity;
import com.neobis.onlineshop.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//NOT WORKING
@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	@Autowired
	public FavoriteService favoriteService;
	
	
	@GetMapping
	public List<FavoriteEntity> getAllFavorites(){
		return favoriteService.getAllFavorites();
		
	}
	
	@GetMapping("/{id}")
	public FavoriteEntity getFavoriteById(@PathVariable Long id) {
		return favoriteService.getFavoriteById(id);
	}
	
	@PostMapping
    FavoriteEntity createFavorite(FavoriteEntity favorite) {
		return favoriteService.createFavorite(favorite);
	}
	
	@PutMapping("/{id}")
	public void updateFavorite(@PathVariable Long id, FavoriteEntity newFavorite) {
		favoriteService.updateFavorite(id, newFavorite);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFavorite(@PathVariable Long id) {
		favoriteService.deleteFavorite(id);
	}
	
	

	

}
