package com.distributor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDto {
    private String gstNumber;
    private String phoneNumber;
    private String name;
    private String email;
    private String buildingName;
    private String area;
    private String city;
    private String zipCode;
}
