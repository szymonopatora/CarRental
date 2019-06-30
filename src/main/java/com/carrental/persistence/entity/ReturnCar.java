package com.carrental.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
