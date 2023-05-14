package com.rodrigo.ShopMate.services;

import com.rodrigo.ShopMate.dtos.ListCategoryDto;
import com.rodrigo.ShopMate.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

        @Autowired
        private CategoryRepository repository;


        public Page<ListCategoryDto> findAll(Pageable paginacao){
            var Category = this.repository.findAll(paginacao).map(ListCategoryDto::new);
            return Category;
        }

        public ListCategoryDto findById(Long id){
            var Category = this.repository.getReferenceById(id);
            return new ListCategoryDto(Category);
        }

}
