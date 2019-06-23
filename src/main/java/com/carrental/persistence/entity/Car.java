package com.carrental.persistence.entity;

import com.carrental.persistence.enums.Body;
import com.carrental.persistence.enums.Status;

import javax.persistence.*;
import java.time.Year;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private Body body;
    private Year YearOfProduction;
    private String color;
    private Status status;
    private Double rentalFee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;
}
