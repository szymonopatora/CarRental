package com.carrental.service;

import com.carrental.common.dto.ReservationDto;
import com.carrental.persistence.entity.Reservation;
import com.carrental.persistence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation(reservationDto.getDateRental(), reservationDto.getDateReturn()
                , reservationDto.getRentalCost(), reservationDto.getClient(), reservationDto.getCar(),
                reservationDto.getBranchRental(), reservationDto.getBranchReturn());
    }
}
