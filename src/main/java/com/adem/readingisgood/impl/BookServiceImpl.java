package com.adem.readingisgood.impl;

import com.adem.readingisgood.common.Utility;
import com.adem.readingisgood.dto.BookDto;
import com.adem.readingisgood.entity.Book;
import com.adem.readingisgood.mapper.BookMapper;
import com.adem.readingisgood.repository.BookRepository;
import com.adem.readingisgood.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.dtoToEntity(bookDto, Utility.cycleAvoidingMappingContext);
        return bookMapper.entityToDto(bookRepository.saveAndFlush(book), Utility.cycleAvoidingMappingContext);
    }
}
