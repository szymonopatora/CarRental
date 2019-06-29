package com.carrental.persistence.entity;

import com.carrental.persistence.embeddable.Address;

import javax.persistence.*;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Address address;
}
