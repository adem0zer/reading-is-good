package com.adem.readingisgood.service;

import com.adem.readingisgood.common.model.QueryByDate;
import com.adem.readingisgood.dto.OrderDto;

import java.util.Date;
import java.util.List;

public interface OrderService {
    boolean createOrder(OrderDto orderDto);

    OrderDto orderById(Long id);

    List<OrderDto> orderByDateIntervals(QueryByDate queryDates);
}
