package com.neobis.onlineshop.repository;

import com.neobis.onlineshop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	//    List<Book> findByNameAndPrice(String name, BigDecimal price);

}
