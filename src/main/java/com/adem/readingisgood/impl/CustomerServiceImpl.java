package com.adem.readingisgood.impl;

import com.adem.readingisgood.dto.UserDto;
import com.adem.readingisgood.entity.User;
import com.adem.readingisgood.mapper.CycleAvoidingMappingContext;
import com.adem.readingisgood.mapper.UserMapper;
import com.adem.readingisgood.repository.UserRepository;
import com.adem.readingisgood.service.CustomerService;
import com.adem.readingisgood.validation.CreateCustomerValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CreateCustomerValidation createCustomerValidation;

    @Override
    @Transactional
    public boolean createCustomer(UserDto userDto) {
        createCustomerValidation.valid(userDto);
        User user = userMapper.dtoToEntity(userDto, new CycleAvoidingMappingContext());
        userRepository.saveAndFlush(user);
        return true;
    }
}
