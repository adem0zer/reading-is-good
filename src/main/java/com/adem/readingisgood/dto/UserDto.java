package com.adem.readingisgood.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private Date createdDate;
    private Date updatedDate;
}
