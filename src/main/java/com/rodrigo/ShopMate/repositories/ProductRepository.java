package com.rodrigo.ShopMate.repositories;

import com.rodrigo.ShopMate.entities.Category;
import com.rodrigo.ShopMate.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
