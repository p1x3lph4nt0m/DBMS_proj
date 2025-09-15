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
    
    private Long billNumber;

    private int orderDay;

    private int orderMonth;

    private int orderYear;

    private String carrier;

    private String provider;
}
