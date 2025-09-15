package com.distributor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DriverDto {
    private String licenseNumber;
    private String aadhaarNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String houseNumber;
    private String locality;
    private String city;
    private String zipCode;
}
