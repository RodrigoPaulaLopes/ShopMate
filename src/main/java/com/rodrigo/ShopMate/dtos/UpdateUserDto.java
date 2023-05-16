package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(@NotNull Long id, @NotBlank String name, @NotBlank @Email String email, @NotBlank String phone, @NotBlank String password) {

    public UpdateUserDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
    }
}
