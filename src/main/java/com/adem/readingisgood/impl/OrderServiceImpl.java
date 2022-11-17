package com.adem.readingisgood.impl;

import com.adem.readingisgood.common.Utility;
import com.adem.readingisgood.common.model.QueryByDate;
import com.adem.readingisgood.dto.OrderDto;
import com.adem.readingisgood.dto.OrderItemsDto;
import com.adem.readingisgood.entity.Book;
import com.adem.readingisgood.entity.Order;
import com.adem.readingisgood.mapper.OrderMapper;
import com.adem.readingisgood.repository.BookRepository;
import com.adem.readingisgood.repository.OrderRepository;
import com.adem.readingisgood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public boolean createOrder(OrderDto orderDto) {
        Order order = orderMapper.dtoToEntity(orderDto, Utility.cycleAvoidingMappingContext);
        List<Long> collect = orderDto.getOrderItems().stream().map(OrderItemsDto::getBook).map(Book::getId).toList();
        List<Book> byIdIn = bookRepository.findByIdIn(collect);

        AtomicLong sum = new AtomicLong(0L);
        Map<Long, Book> bookMap = new HashMap<>();
        byIdIn.forEach(a -> bookMap.put(a.getId(), a));

        orderDto.getOrderItems().forEach(o -> {
            Book book = bookMap.get(o.getBook().getId());
            if (o.getCount() <= book.getQuantity()) {
                // update stock
                book.setQuantity(book.getQuantity() - o.getCount());
                sum.set(sum.get() + o.getCount() * book.getPrice());
            }
        });

        order.setTotalPrice(sum.get());
        bookRepository.saveAllAndFlush(bookMap.values());
        orderRepository.saveAndFlush(order);
        Utility.logger.info("SUCCESS");
        return true;
    }

    @Override
    public OrderDto orderById(Long id) {
        //validation
        return orderRepository.findById(id).map(value -> orderMapper.entityToDto(value, Utility.cycleAvoidingMappingContext)).orElse(null);
    }

    @Override
    public List<OrderDto> orderByDateIntervals(QueryByDate queryDates) {
        //validation
        List<Order> byCreatedDateBetween = orderRepository.findByCreatedDateBetween(queryDates.getStartDate(), queryDates.getEndDate());
        return orderMapper.listEntityToListDto(byCreatedDateBetween, Utility.cycleAvoidingMappingContext);
    }
}
