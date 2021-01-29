package com.neobis.onlineshop.repository;

import com.neobis.onlineshop.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> { //??? long

}
