package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.Order;
import com.rodrigo.ShopMate.entities.OrderItem;
import com.rodrigo.ShopMate.entities.pk.OrderItemPk;
import com.rodrigo.ShopMate.enums.OrderStatus;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public record ListarOrdemDto(Long id, Instant moment, OrderStatus status, ListUserDto Users, Set<ListOrderItemDto> ordemItem) {

    public ListarOrdemDto(Order order){
        this(order.getId(), order.getMoment(), order.getOrderStatus(), new ListUserDto(order.getUser()), new HashSet<>(order.getItems().stream().map(ListOrderItemDto::new).toList()));
    }
}
