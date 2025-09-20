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
    private Long id;
    private String name;
    private Double tax;
    private String company;
    private Long stock;
    private Double price;
    private Double mrp;
    private String weight;
}
