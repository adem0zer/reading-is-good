package com.adem.readingisgood.controller;

import com.adem.readingisgood.dto.UserDto;
import com.adem.readingisgood.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("create")
    public boolean create(@RequestBody UserDto userDto) {
        return customerService.createCustomer(userDto);
    }
}
