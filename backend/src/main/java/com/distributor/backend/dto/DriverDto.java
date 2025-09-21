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
    private String license;
    private String aadhaar;
    private String fname;
    private String lname;
    private String phone;
    private String house;
    private String locality;
    private String city;
    private String zip;
}
