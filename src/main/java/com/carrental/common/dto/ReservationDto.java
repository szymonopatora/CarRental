package com.carrental.common.dto;

import com.carrental.persistence.entity.Branch;
import com.carrental.persistence.entity.Car;
import com.carrental.persistence.entity.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class ReservationDto {

    @NotBlank
    private LocalDate dateRental;
    @NotBlank
    private LocalDate dateReturn;
    @NotBlank
    private Double rentalCost;
    @NotBlank
    private User client;
    @NotBlank
    private Car car;
    @NotBlank
    private Branch branchRental;
    @NotBlank
    private Branch branchReturn;

    public ReservationDto(Branch branch1, Branch branch2) {
    }
}
