package com.carrental.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.carrental.persistence.entity.embeddable.Address;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    public Branch(Address address) {
        this.address = address;
    }
}
