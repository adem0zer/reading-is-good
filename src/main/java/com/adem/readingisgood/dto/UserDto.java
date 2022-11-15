package com.adem.readingisgood.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private Date createdDate;
    private Date updatedDate;
}
