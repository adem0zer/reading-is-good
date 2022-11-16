package com.adem.readingisgood.dto;

import com.adem.readingisgood.entity.Book;
import com.adem.readingisgood.entity.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderItemsDto extends BaseDto {

    private Long count;
    private Book book;
    private Order order;
}
