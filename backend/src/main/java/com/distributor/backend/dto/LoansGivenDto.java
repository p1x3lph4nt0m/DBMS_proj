package com.distributor.backend.dto;

import com.distributor.backend.entity.Buyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoansGivenDto {
    private Long Id;
    private Double rate;
    private Double amt;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer duration;
    private String gstNumber;
    private String Name;
}
