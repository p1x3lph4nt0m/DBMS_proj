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
    private String gst;
    private String phone;
    private String name;
    private String email;
    private String building;
    private String area;
    private String city;
    private String zip;
}
