package com.adem.readingisgood.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "book_id")
    private Long id;

    @Basic
    @Column(name = "book_name")
    private String bookName;

    @Basic
    @Column(name = "quantity")
    private Long quantity;
}
