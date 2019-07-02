package com.carrental.service;

import com.carrental.CarRentalApplication;
import com.carrental.common.dto.ReservationDto;
import com.carrental.persistence.embeddable.Address;
import com.carrental.persistence.entity.Branch;
import com.carrental.persistence.entity.Reservation;
import com.carrental.persistence.repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CarRentalApplication.class })
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;


    @Test
    public void shouldSaveReservation() {

        //given
        Address address1 = new Address("Mala", "2/1", "60-433", "Poznań", "Polska");
        Address address2 = new Address("Wielka", "22/11", "62-433", "Poznań", "Polska");
        Branch branchRental = new Branch(address1);
        Branch branchReturn = new Branch(address2);
        Reservation reservation = new Reservation();
        reservation.setBranchRental(branchRental);
        reservation.setBranchReturn(branchReturn);

        ReservationDto reservationDto = new ReservationDto(branchRental, branchReturn);
        int expectedSize = 1;

        //when
        reservationService.saveReservation(reservationDto);
        int size = reservationRepository.findAll().size();

        //then
        assertEquals(expectedSize, size);
    }
}