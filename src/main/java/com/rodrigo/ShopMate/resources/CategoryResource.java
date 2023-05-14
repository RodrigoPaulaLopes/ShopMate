package com.rodrigo.ShopMate.resources;

import com.rodrigo.ShopMate.dtos.ListCategoryDto;
import com.rodrigo.ShopMate.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<Page<ListCategoryDto>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(service.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListCategoryDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
