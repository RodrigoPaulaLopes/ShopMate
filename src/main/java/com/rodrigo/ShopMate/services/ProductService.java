package com.rodrigo.ShopMate.services;

import com.rodrigo.ShopMate.dtos.ListProductDto;
import com.rodrigo.ShopMate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

        @Autowired
        private ProductRepository repository;


        public Page<ListProductDto> findAll(Pageable paginacao){
            var Product = this.repository.findAll(paginacao).map(ListProductDto::new);
            return Product;
        }

        public ListProductDto findById(Long id){
            var Product = this.repository.getReferenceById(id);
            return new ListProductDto(Product);
        }

}
