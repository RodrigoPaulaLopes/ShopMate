package com.rodrigo.ShopMate.services;

import com.rodrigo.ShopMate.dtos.ListarOrdemDto;
import com.rodrigo.ShopMate.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Page<ListarOrdemDto> findAll(Pageable paginacao) {
        return orderRepository.findAll(paginacao).map(ListarOrdemDto::new);
    }

    public ListarOrdemDto findById(Long id) {
        return new ListarOrdemDto(orderRepository.getReferenceById(id));
    }
}
