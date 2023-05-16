package com.rodrigo.ShopMate.repositories;

import com.rodrigo.ShopMate.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
