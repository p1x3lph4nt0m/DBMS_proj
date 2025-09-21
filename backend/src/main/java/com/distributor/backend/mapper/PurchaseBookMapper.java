package com.distributor.backend.mapper;

import com.distributor.backend.dto.PurchaseBookDto;
import com.distributor.backend.entity.PurchaseBook;

public class PurchaseBookMapper {
    public static PurchaseBookDto maptoPurchaseBookDto(PurchaseBook purchaseBook){
        return new PurchaseBookDto(
                purchaseBook.getBillNumber(),
                purchaseBook.getOrderDay(),
                purchaseBook.getOrderMonth(),
                purchaseBook.getOrderYear(),
                purchaseBook.getCarrier().getLicense(),
                purchaseBook.getProvider().getGst()
        );
    }
    public static PurchaseBook maptoPurchaseBook(PurchaseBookDto purchaseBookDto){
        return new PurchaseBook(
                purchaseBookDto.getBillNumber(),
                purchaseBookDto.getOrderDay(),
                purchaseBookDto.getOrderMonth(),
                purchaseBookDto.getOrderYear(),
                null,
                null
        );
    }
}
