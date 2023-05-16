package com.rodrigo.ShopMate.resources;

import com.rodrigo.ShopMate.dtos.InsertUserDto;
import com.rodrigo.ShopMate.dtos.ListUserDto;
import com.rodrigo.ShopMate.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<ListUserDto>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(service.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListUserDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }


    @PostMapping
    @Transactional
    public ResponseEntity<ListUserDto> create(@RequestBody InsertUserDto user, UriComponentsBuilder builder){
        var userdto = service.insert(user);
        var uri = builder.path("/users/{id}").buildAndExpand(userdto.id()).toUri();
        return ResponseEntity.created(uri).body(userdto);
    }


}
