package com.carrental.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User employeeRenting;

    private LocalDate dateRental;

    private String remarks;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Reservation reservation;
}
