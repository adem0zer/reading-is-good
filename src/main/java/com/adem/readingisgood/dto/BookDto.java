package com.adem.readingisgood.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BookDto implements Serializable {

    private Long id;
    private String bookName;
    private Long quantity;
    private Date createdDate;
    private Date updatedDate;
}
