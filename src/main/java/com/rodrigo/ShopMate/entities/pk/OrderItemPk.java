package com.rodrigo.ShopMate.entities.pk;

import com.rodrigo.ShopMate.entities.Order;
import com.rodrigo.ShopMate.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable

@Getter
@Setter
@EqualsAndHashCode(of = "product")
public class OrderItemPk implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
