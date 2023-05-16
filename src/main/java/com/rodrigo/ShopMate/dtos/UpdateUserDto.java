package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.User;

public record UpdateUserDto(Long id, String name, String email, String phone, String password) {

    public UpdateUserDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
    }
}
