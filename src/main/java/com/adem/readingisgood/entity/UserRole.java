package com.adem.readingisgood.entity;

import javax.persistence.*;
import java.util.List;


public class UserRole extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "user_role_id")
    private long userRoleId;

    @Basic
    @Column(name = "user_id")
    private long userId;

    @Basic
    @Column(name = "role_id")
    private long roleId;

    @OneToMany
    @JoinColumn(name = "role_id")
    List<Role> roles;
}
