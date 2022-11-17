package com.adem.readingisgood.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends BaseDto {

    private Long userId;
    private Long totalPrice;
    private String status;
    List<OrderItemsDto> orderItems;
}
