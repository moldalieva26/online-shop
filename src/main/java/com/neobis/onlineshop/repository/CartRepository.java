package com.neobis.onlineshop.repository;

import com.neobis.onlineshop.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
