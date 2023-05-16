package com.rodrigo.ShopMate.dtos;

import com.rodrigo.ShopMate.entities.Order;
import com.rodrigo.ShopMate.entities.OrderItem;
import com.rodrigo.ShopMate.entities.Product;

public record ListOrderItemDto(Long product_id, Long order_id, Integer quantity, Double price) {

    public ListOrderItemDto(OrderItem orderItem){
        this(orderItem.getProduct().getId(), orderItem.getOrder().getId(), orderItem.getQuantity(), orderItem.getPrice());
    }

}
