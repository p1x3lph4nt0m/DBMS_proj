package com.distributor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesListDto {

    private Long billNumber;

    private Long itemId;

    private Double discount;

    private Long quantity;
}
