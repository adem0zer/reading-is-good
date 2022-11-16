package com.adem.readingisgood.service;

import com.adem.readingisgood.dto.OrderDto;

public interface OrderService {
    boolean createOrder(OrderDto orderDto);
}
