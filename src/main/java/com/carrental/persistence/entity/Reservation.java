package com.carrental.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime registrationDate = LocalDateTime.now();

    @OneToOne()
    private User client;

    @OneToOne()
    private Car car;

    @OneToOne()
    private Branch branchRental;

    @OneToOne()
    private Branch branchReturn;


    public Reservation(LocalDate dateRental, LocalDate dateReturn, Double rentalCost, User client,
                       Car car, Branch branchRental, Branch branchReturn) {
        this.dateRental = dateRental;
        this.dateReturn = dateReturn;
        this.rentalCost = rentalCost;
        this.client = client;
        this.car = car;
        this.branchRental = branchRental;
        this.branchReturn = branchReturn;
    }
}
