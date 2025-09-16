package com.distributor.backend.mapper;

import com.distributor.backend.dto.SalesListDto;
import com.distributor.backend.entity.*;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.repository.ItemsRepository;
import com.distributor.backend.repository.SalesBookRepository;

public class SalesListMapper {
    public static SalesBookRepository salesBookRepository;
    public static ItemsRepository itemsRepository;
    public static SalesListDto maptoSalesListDto(SalesList salesList){
        return new SalesListDto(
                salesList.getBillNumber(),
                salesList.getItemId(),
                salesList.getDiscount(),
                salesList.getQuantity()
        );
    }
    public static SalesList maptoSalesList(SalesListDto salesListDto){
        Items items = itemsRepository.findById(salesListDto.getItemId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Item does not exist with Item Id: "+salesListDto.getItemId())
                );
        SalesBook salesBook = salesBookRepository.findById(salesListDto.getBillNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Purchase Book does not exist with the given Bill Number: "+ salesListDto.getBillNumber())
                );
        return new SalesList(
                salesListDto.getBillNumber(),
                salesListDto.getItemId(),
                salesListDto.getDiscount(),
                salesListDto.getQuantity(),
                salesBook,
                items
        );
    }
}
