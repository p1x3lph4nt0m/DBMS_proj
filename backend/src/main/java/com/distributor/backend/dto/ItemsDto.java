package com.distributor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDto {
    private Long Id;
    private String name;
    private Double taxRate;
    private String company;
    private Long quantity;
    private Double sp;
    private Double mrp;
    private Double wt;
}
