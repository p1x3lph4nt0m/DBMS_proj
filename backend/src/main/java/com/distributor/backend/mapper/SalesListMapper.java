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
            salesList.getBill_number(),
            salesList.getItem_id(),
            salesList.getDiscount(),
            salesList.getQuantity()
        );
    }
    public static SalesList maptoSalesList(SalesListDto salesListDto){
        Items items = itemsRepository.findById(salesListDto.getItem_id())
            .orElseThrow(
                    () -> new ResourceNotFoundException("Item does not exist with Item Id: "+salesListDto.getItem_id())
            );
        SalesBook salesBook = salesBookRepository.findById(salesListDto.getBill_number())
            .orElseThrow(
                    () -> new ResourceNotFoundException("Purchase Book does not exist with the given Bill Number: "+ salesListDto.getBill_number())
            );
        return new SalesList(
            salesListDto.getBill_number(),
            salesListDto.getItem_id(),
            salesListDto.getDiscount(),
            salesListDto.getQuantity(),
            salesBook,
            items
        );
    }
}
