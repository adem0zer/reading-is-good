package com.adem.readingisgood.service;

import com.adem.readingisgood.dto.UserDto;

public interface CustomerService {
    boolean createCustomer(UserDto userDto);
}
