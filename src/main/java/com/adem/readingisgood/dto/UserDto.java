package com.adem.readingisgood.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDto{

    private String name;
    private String lastName;
    private String password;
    private String email;
}
