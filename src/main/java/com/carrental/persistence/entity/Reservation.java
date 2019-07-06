package com.carrental.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private static final double DIFFERENT_RETURN_BRANCH = 150.00;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateRental;
    private LocalDate dateReturn;
    private double rentalCost = calculateRentalCost();
    private LocalDateTime reservationDate = LocalDateTime.now();
    private LocalDateTime cancelDate = LocalDateTime.now();

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

    public Double calculateRentalCost() {

        Car car = new Car();
        double rentalFee = car.getRentalFee();
        Duration rentalDuration = Duration.between(dateRental, dateReturn);

        long rentalTime = Math.abs(rentalDuration.toDays());

        Duration cancellationPeriod = Duration.between(cancelDate, dateRental);

        long timeRemainingToRental = Math.abs(cancellationPeriod.toDays());

        if (timeRemainingToRental > 2) {
            rentalCost = 0.0;
        } else if (timeRemainingToRental < 2) {
            rentalCost = (rentalCost) * 0.2;
        } else {
            rentalCost = rentalFee * rentalTime;
            if (!branchRental.equals(branchReturn)) {
                rentalCost = rentalCost + DIFFERENT_RETURN_BRANCH;
            }
        }
        return rentalCost;
    }
}
