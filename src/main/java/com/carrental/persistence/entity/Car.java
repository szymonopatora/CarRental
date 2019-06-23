package com.carrental.persistence.entity;

import com.carrental.persistence.enums.Body;
import com.carrental.persistence.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private Body body;
    private Year YearOfProduction;
    private String color;
    private Status status;
    private Double rentalFee;

}
