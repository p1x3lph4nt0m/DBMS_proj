package com.distributor.backend.service;

import java.util.List;

import com.distributor.backend.dto.PurchaseListDto;

public interface PurchaseListService {
    PurchaseListDto addPurchaseList(PurchaseListDto purchaseListDto);
    void deletePurchaseList(Long billNumber, Long itemId);
    List<Object[]> findByBillNumber(Long billNumber);
}
