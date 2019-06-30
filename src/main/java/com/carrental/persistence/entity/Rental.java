package com.carrental.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

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
