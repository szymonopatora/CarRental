package com.carrental.controller;

import com.carrental.common.dto.ReservationDto;
import com.carrental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation")
    public String reservCar(Model model) {
        model.addAttribute("reservation",new ReservationDto());
        return "reservationForm";
    }

    @PostMapping
    public String reservCar(@ModelAttribute("reservation")@Valid ReservationDto reservationDto,
                            BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "reservationForm";
        }
        reservationService.saveReservation(reservationDto);
        return "redirect:/";
    }
}
