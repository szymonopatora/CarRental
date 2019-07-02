package com.carrental.controller;

import com.carrental.persistence.entity.Reservation;
import com.carrental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


}
