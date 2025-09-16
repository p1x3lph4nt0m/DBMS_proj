package com.distributor.backend.mapper;

import com.distributor.backend.dto.PurchaseListDto;
import com.distributor.backend.entity.Items;
import com.distributor.backend.entity.PurchaseBook;
import com.distributor.backend.entity.PurchaseList;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.repository.ItemsRepository;
import com.distributor.backend.repository.PurchaseBookRepository;

public class PurchaseListMapper {
    public static PurchaseBookRepository purchaseBookRepository;
    public static ItemsRepository itemsRepository;
    public static PurchaseListDto maptoPurchaseListDto(PurchaseList purchaseList){
        return new PurchaseListDto(
                purchaseList.getBillNumber(),
                purchaseList.getItemId(),
                purchaseList.getDiscount(),
                purchaseList.getQuantity()
        );
    }
    public static PurchaseList maptoPurchaseList(PurchaseListDto purchaseListDto){
        Items items = itemsRepository.findById(purchaseListDto.getItemId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Item does not exist with Item Id: "+purchaseListDto.getItemId())
                );
        PurchaseBook purchaseBook = purchaseBookRepository.findById(purchaseListDto.getBillNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Purchase Book does not exist with the given Bill Number: "+ purchaseListDto.getBillNumber())
                );
        return new PurchaseList(
                purchaseListDto.getBillNumber(),
                purchaseListDto.getItemId(),
                purchaseListDto.getDiscount(),
                purchaseListDto.getQuantity(),
                purchaseBook,
                items
        );
    }
}
