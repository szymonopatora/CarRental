package com.carrental.common.dto;

import com.carrental.persistence.entity.embeddable.Address;
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
