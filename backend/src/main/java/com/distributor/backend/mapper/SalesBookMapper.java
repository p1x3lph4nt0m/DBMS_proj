package com.distributor.backend.mapper;

import com.distributor.backend.dto.SalesBookDto;
import com.distributor.backend.entity.SalesBook;

public class SalesBookMapper {
    public static SalesBookDto maptosalesBookDto(SalesBook salesbook){
        return new SalesBookDto(
                salesbook.getBill_number(),
                salesbook.getOrder_day(),
                salesbook.getOrder_month(),
                salesbook.getOrder_year(),
                salesbook.getCarrier().getLicense(),
                salesbook.getCustomer().getGst()
        );
    }
    public static SalesBook maptoSalesBook(SalesBookDto salesBookDto){
        return new SalesBook(
                salesBookDto.getBill_number(),
                salesBookDto.getOrder_day(),
                salesBookDto.getOrder_month(),
                salesBookDto.getOrder_year(),
                null,
                null
        );
    }
}
