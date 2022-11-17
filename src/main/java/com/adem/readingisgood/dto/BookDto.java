package com.adem.readingisgood.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookDto extends BaseDto {

    private String bookName;
    private Long quantity;
}
