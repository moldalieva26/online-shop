package com.neobis.onlineshop.repository;

import com.neobis.onlineshop.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

}
