package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.Category;
import com.rodrigo.ShopMate.entities.Product;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public record ListProductDto(Long id, String name, String description, Double price, String imgUri, Set<ListCategoryDto> categories) {

    public ListProductDto(Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUri(), new HashSet<>(product.getCategories().stream().map(ListCategoryDto::new).toList()));
    }
}
