package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.Order;

import java.time.Instant;

public record ListarOrdemDto(Long id, Instant moment, ListUserDto users) {

    public ListarOrdemDto(Order order){
        this(order.getId(), order.getMoment(), new ListUserDto(order.getUser()));
    }
}
