package com.rodrigo.ShopMate.services;

import com.rodrigo.ShopMate.dtos.ListUserDto;
import com.rodrigo.ShopMate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        @Autowired
        private UserRepository repository;


        public Page<ListUserDto> findAll(Pageable paginacao){
            var user = this.repository.findAll(paginacao).map(ListUserDto::new);
            return user;
        }

}
