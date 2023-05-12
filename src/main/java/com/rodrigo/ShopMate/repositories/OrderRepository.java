package com.rodrigo.ShopMate.repositories;

import com.rodrigo.ShopMate.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
