package com.adem.readingisgood.controller;

import com.adem.readingisgood.common.model.QueryByDate;
import com.adem.readingisgood.dto.OrderDto;
import com.adem.readingisgood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("create")
    public boolean create(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("orderById")
    public OrderDto orderById(@PathVariable Long id) {
        return orderService.orderById(id);
    }

    @PostMapping("orderByDateIntervals")
    List<OrderDto> orderByDateIntervals(@RequestBody QueryByDate queryDates) {
        return orderService.orderByDateIntervals(queryDates);
    }
}
