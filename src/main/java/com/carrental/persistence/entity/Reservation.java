package com.carrental.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateRental;
    private LocalDate dateReturn;
    private Double rentalCost;

    @OneToOne()
    private Client client;

    @OneToOne()
    private Car car;

    @OneToOne()
    private Branch branchRental;

    @OneToOne()
    private Branch branchReturn;
}
