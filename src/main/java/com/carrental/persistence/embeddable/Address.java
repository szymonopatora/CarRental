package com.carrental.persistence.embeddable;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    private String street;

    private String streetNumber;

    private String zipCode;

    private String city;

    private String country;
}