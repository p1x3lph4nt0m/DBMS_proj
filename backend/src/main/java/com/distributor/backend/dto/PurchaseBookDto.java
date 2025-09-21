package com.distributor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseBookDto {

    private Long bill_number;

    private int order_day;

    private int order_month;

    private int order_year;

    private String carrier;   // Foreign key to Driver.licenseNumber

    private String provider;      // Foreign key to Supplier.gstNumber
}
