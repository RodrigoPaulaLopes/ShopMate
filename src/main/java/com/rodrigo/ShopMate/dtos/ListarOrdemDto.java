package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.Order;
import com.rodrigo.ShopMate.enums.OrderStatus;

import java.time.Instant;

public record ListarOrdemDto(Long id, Instant moment, OrderStatus status, ListUserDto users) {

    public ListarOrdemDto(Order order){
        this(order.getId(), order.getMoment(), order.getOrderStatus(), new ListUserDto(order.getUser()));
    }
}
