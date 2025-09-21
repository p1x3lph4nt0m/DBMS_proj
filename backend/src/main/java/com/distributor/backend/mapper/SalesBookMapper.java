package com.distributor.backend.mapper;

import com.distributor.backend.dto.SalesBookDto;
import com.distributor.backend.entity.SalesBook;

public class SalesBookMapper {
    public static SalesBookDto maptosalesBookDto(SalesBook salesbook){
        return new SalesBookDto(
                salesbook.getBillNumber(),
                salesbook.getOrderDay(),
                salesbook.getOrderMonth(),
                salesbook.getOrderYear(),
                salesbook.getCarrier().getLicenseNumber(),
                salesbook.getCustomer().getGstNumber()
        );
    }
    public static SalesBook maptoSalesBook(SalesBookDto salesBookDto){
        return new SalesBook(
                salesBookDto.getBillNumber(),
                salesBookDto.getOrderDay(),
                salesBookDto.getOrderMonth(),
                salesBookDto.getOrderYear(),
                null,
                null
        );
    }
}
