package com.rodrigo.ShopMate.resources;

import com.rodrigo.ShopMate.dtos.ListUserDto;
import com.rodrigo.ShopMate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
