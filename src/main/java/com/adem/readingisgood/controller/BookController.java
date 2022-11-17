package com.adem.readingisgood.controller;

import com.adem.readingisgood.dto.BookDto;
import com.adem.readingisgood.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("create")
    public BookDto create(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }
}
