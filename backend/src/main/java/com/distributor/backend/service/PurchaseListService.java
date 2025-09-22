package com.distributor.backend.service;

import com.distributor.backend.dto.PurchaseListDto;

public interface PurchaseListService {
    PurchaseListDto addPurchaseList(PurchaseListDto purchaseListDto);
    void deletePurchaseList(Long billNumber, Long itemId);
}
