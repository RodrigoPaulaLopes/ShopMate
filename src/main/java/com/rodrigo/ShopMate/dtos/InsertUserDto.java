package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.User;

public record InsertUserDto(String name, String email, String phone, String password) {

    public InsertUserDto(User user){
        this(user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
    }
}
