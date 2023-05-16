package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InsertUserDto(@NotBlank String name, @NotBlank @Email String email, @NotBlank String phone, @NotBlank String password) {

    public InsertUserDto(User user){
        this(user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
    }
}
