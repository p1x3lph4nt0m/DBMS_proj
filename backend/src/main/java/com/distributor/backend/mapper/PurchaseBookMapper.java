package com.distributor.backend.mapper;

import com.distributor.backend.dto.PurchaseBookDto;
import com.distributor.backend.entity.PurchaseBook;

public class PurchaseBookMapper {
    public static PurchaseBookDto maptoPurchaseBookDto(PurchaseBook purchaseBook){
        return new PurchaseBookDto(
                purchaseBook.getBill_number(),
                purchaseBook.getOrder_day(),
                purchaseBook.getOrder_month(),
                purchaseBook.getOrder_year(),
                purchaseBook.getCarrier().getLicense(),
                purchaseBook.getProvider().getGst()
        );
    }
    public static PurchaseBook maptoPurchaseBook(PurchaseBookDto purchaseBookDto){
        return new PurchaseBook(
                purchaseBookDto.getBill_number(),
                purchaseBookDto.getOrder_day(),
                purchaseBookDto.getOrder_month(),
                purchaseBookDto.getOrder_year(),
                null,
                null
        );
    }
}
