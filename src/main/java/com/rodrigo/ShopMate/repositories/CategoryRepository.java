package com.rodrigo.ShopMate.repositories;

import com.rodrigo.ShopMate.entities.Category;
import com.rodrigo.ShopMate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
