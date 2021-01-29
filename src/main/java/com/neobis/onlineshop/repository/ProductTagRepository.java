package com.neobis.onlineshop.repository;

import com.neobis.onlineshop.entity.ProductTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTagRepository extends JpaRepository<ProductTagEntity, Long> { //? needed? i do not have PK in this table

}
