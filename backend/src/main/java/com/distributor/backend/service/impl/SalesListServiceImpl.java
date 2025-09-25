package com.distributor.backend.service.impl;

import org.springframework.stereotype.Service;

import com.distributor.backend.dto.SalesListDto;
import com.distributor.backend.entity.Items;
import com.distributor.backend.entity.SalesBook;
import com.distributor.backend.entity.SalesList;
import com.distributor.backend.entity.SalesListId;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.SalesListMapper;
import com.distributor.backend.repository.ItemsRepository;
import com.distributor.backend.repository.SalesBookRepository;
import com.distributor.backend.repository.SalesListRepository;
import com.distributor.backend.service.SalesListService;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class SalesListServiceImpl implements SalesListService{

    private SalesListRepository salesListRepository;
    private ItemsRepository itemsRepository;
    private SalesBookRepository salesBookRepository;

    @Override
    public SalesListDto addSalesList(SalesListDto salesListDto) {
        
        Items item = itemsRepository.findById(salesListDto.getItem_id())
            .orElseThrow(() -> new ResourceNotFoundException(
                "Item does not exist with Item Id: " + salesListDto.getItem_id()
            ));
        SalesBook salesBook = salesBookRepository.findById(salesListDto.getBill_number())
            .orElseThrow(() -> new ResourceNotFoundException(
                "Sales Book does not exist with Bill Number: " + salesListDto.getBill_number()
            ));
        if (item.getStock() < salesListDto.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for Item Id: " + salesListDto.getItem_id());
        }

        SalesListId id = new SalesListId(
            salesListDto.getBill_number(),
            salesListDto.getItem_id()
        );

        SalesList salesList;
        if (salesListRepository.existsById(id)) {
            salesList = salesListRepository.findById(id).get();
            Long oldQuantity = salesList.getQuantity();
            Long newQuantity = oldQuantity + salesListDto.getQuantity();
            salesList.setQuantity(newQuantity);

        } else {
            salesList = new SalesList(
            salesListDto.getBill_number(),
            salesListDto.getItem_id(),
            salesListDto.getDiscount(),
            salesListDto.getQuantity(),
            salesBook,
            item
        );
        }

        SalesList savedSalesList = salesListRepository.save(salesList);

        item.setStock(item.getStock() - salesListDto.getQuantity());
        itemsRepository.save(item);

        return SalesListMapper.maptoSalesListDto(savedSalesList);
    }

    @Override
    public void deleteSalesList(Long billNumber, Long itemId) {
        SalesListId id = new SalesListId(billNumber, itemId);

        SalesList salesList = salesListRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "SalesList entry not found for Bill: " + billNumber + " and Item: " + itemId
            ));

        Items item = salesList.getItem();
        item.setStock(item.getStock() + salesList.getQuantity());
        itemsRepository.save(item);

        salesListRepository.delete(salesList);
    }

    @Override
    public List<Object[]> findByBillNumber(Long billNumber) {
        List<Object[]> rows = salesListRepository.findByBillNumber(billNumber);
        return rows == null ? Collections.emptyList() : rows;
    }
}
