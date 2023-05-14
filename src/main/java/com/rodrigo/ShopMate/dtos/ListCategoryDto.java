package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.Category;

import java.util.List;
import java.util.Set;

public record ListCategoryDto(Long id, String nome) {

    public ListCategoryDto(Category category) {
        this(category.getId(), category.getName());
    }


}
