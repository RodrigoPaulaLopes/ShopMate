package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.User;

public record ListUserDto(Long id, String name, String email, String password) {


    public ListUserDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
}
