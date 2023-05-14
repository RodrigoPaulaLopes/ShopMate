package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.Category;

public record ListCategoryDto(Long id, String nome) {

    public ListCategoryDto(Category category){
        this(category.getId(), category.getName());
    }
}
