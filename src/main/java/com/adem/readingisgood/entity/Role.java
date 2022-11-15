package com.adem.readingisgood.entity;

import javax.persistence.*;


public class Role extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "role_id")
    private long roleId;

    @Basic
    @Column(name = "role_name")
    private String roleName;
}
