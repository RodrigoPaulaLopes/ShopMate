package com.rodrigo.ShopMate.services;

import com.rodrigo.ShopMate.dtos.InsertUserDto;
import com.rodrigo.ShopMate.dtos.ListUserDto;
import com.rodrigo.ShopMate.dtos.UpdateUserDto;
import com.rodrigo.ShopMate.entities.User;
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


    public Page<ListUserDto> findAll(Pageable paginacao) {
        var User = this.repository.findAll(paginacao).map(ListUserDto::new);
        return User;
    }

    public ListUserDto findById(Long id) {
        var User = this.repository.getReferenceById(id);
        return new ListUserDto(User);
    }

    public ListUserDto insert(InsertUserDto user) {
        var oldUser = new User(user);
        var newUser = this.repository.save(oldUser);
        return new ListUserDto(newUser);
    }

    public void delete(Long id) {
        var user = this.repository.getReferenceById(id);

        this.repository.delete(user);
    }

    public ListUserDto update(UpdateUserDto user) {
        var oldUser = this.repository.getReferenceById(user.id());
        oldUser.atualizar(user);
        var newUser = this.repository.save(oldUser);
        return new ListUserDto(newUser);
    }
}
