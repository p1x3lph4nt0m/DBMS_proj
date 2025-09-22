package com.distributor.backend.service.impl;

import org.springframework.stereotype.Service;

import com.distributor.backend.dto.PurchaseListDto;
import com.distributor.backend.entity.Items;
import com.distributor.backend.entity.PurchaseBook;
import com.distributor.backend.entity.PurchaseList;
import com.distributor.backend.entity.PurchaseListId;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.PurchaseListMapper;
import com.distributor.backend.repository.ItemsRepository;
import com.distributor.backend.repository.PurchaseBookRepository;
import com.distributor.backend.repository.PurchaseListRepository;
import com.distributor.backend.service.PurchaseListService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PurchaseListServiceImpl implements PurchaseListService{
    
    private  PurchaseListRepository purchaseListRepository;
    private  ItemsRepository itemsRepository;
    private  PurchaseBookRepository purchaseBookRepository;

    @Override
    public PurchaseListDto addPurchaseList(PurchaseListDto purchaseListDto) {
        // Validate Item
        Items item = itemsRepository.findById(purchaseListDto.getItem_id())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Item does not exist with Item Id: " + purchaseListDto.getItem_id()
                ));

        // Validate PurchaseBook
        PurchaseBook purchaseBook = purchaseBookRepository.findById(purchaseListDto.getBill_number())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Purchase Book does not exist with Bill Number: " + purchaseListDto.getBill_number()
                ));
        
        // Create PurchaseList entity
        PurchaseList purchaseList = new PurchaseList(
                purchaseListDto.getBill_number(),
                purchaseListDto.getItem_id(),
                purchaseListDto.getDiscount(),
                purchaseListDto.getQuantity(),
                purchaseBook,
                item
        );

        PurchaseList savedPurchaseList = purchaseListRepository.save(purchaseList);

        // Update stock quantity
        item.setStock(item.getStock() + purchaseListDto.getQuantity());
        itemsRepository.save(item);
        return PurchaseListMapper.maptoPurchaseListDto(savedPurchaseList);
    }

    @Override
    public void deletePurchaseList(Long billNumber, Long itemId) {
        PurchaseListId id = new PurchaseListId(billNumber, itemId);

        PurchaseList purchaseList = purchaseListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PurchaseList entry not found for Bill: " + billNumber + " and Item: " + itemId
                ));

        // Decrease stock (reverse the purchase effect)
        Items item = purchaseList.getItem();
        item.setStock(item.getStock() - purchaseList.getQuantity());
        itemsRepository.save(item);

        // Delete entry
        purchaseListRepository.delete(purchaseList);
    }
}
