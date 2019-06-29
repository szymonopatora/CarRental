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
<<<<<<< Updated upstream
    @JoinColumn(name = "client_id")
    private Client client;
=======
    private User client;
>>>>>>> Stashed changes

    @OneToOne()
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne()
    @JoinColumn(name = "branch_id")
    private Branch branchRental;

    @OneToOne()
    @JoinColumn(name = "branch_id")
    private Branch branchReturn;
}
