package com.neobis.onlineshop.service;


import com.neobis.onlineshop.entity.FavoriteEntity;
import com.neobis.onlineshop.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
	@Autowired
	public FavoriteRepository favoriteRepository;

	public List<FavoriteEntity> getAllFavorites() {
		return favoriteRepository.findAll();
	}

	public FavoriteEntity getFavoriteById(Long id) {
		return favoriteRepository.findById(id).get();
	}

	public FavoriteEntity createFavorite(FavoriteEntity favorite) {
		return favoriteRepository.save(favorite);
	}

	public void deleteFavorite(Long id) {
		favoriteRepository.deleteById(id);
		
	}

	public void updateFavorite(Long id, FavoriteEntity newFavorite) {
		if(favoriteRepository.findById(id).isPresent()){
			FavoriteEntity favorite = favoriteRepository.findById(id).get();
			favorite.setCustomerId(newFavorite.getCustomerId()); //?
			favorite.setProductId(newFavorite.getProductId());
			
		}
	} 
	
	

}
