package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.User;

public record ListUserDto(Long id, String name, String email, String password) {


    public ListUserDto(User User){
        this(User.getId(), User.getName(), User.getEmail(), User.getPassword());
    }
}
