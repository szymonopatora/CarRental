package com.carrental.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ReturnCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User employeeReturning;

    private LocalDate dateReturn;

    private Double extraCost;

    private String remarks;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Reservation reservation;
}
