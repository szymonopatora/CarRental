package com.carrental.common;

import com.carrental.persistence.embeddable.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDto {

    private Long id;

    private Address address;
}
