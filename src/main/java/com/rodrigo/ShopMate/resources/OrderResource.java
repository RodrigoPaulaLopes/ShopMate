package com.rodrigo.ShopMate.resources;

import com.rodrigo.ShopMate.dtos.ListarOrdemDto;
import com.rodrigo.ShopMate.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderResource {
    @Autowired
    private OrderService orderService;


    @GetMapping
    public ResponseEntity<Page<ListarOrdemDto>> findAll(Pageable paginacao){
        return ResponseEntity.ok().body(orderService.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListarOrdemDto> findAll(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findById(id));
    }


}
