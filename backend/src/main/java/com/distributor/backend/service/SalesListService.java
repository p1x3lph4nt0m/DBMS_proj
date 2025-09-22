package com.distributor.backend.service;

import com.distributor.backend.dto.SalesListDto;

public interface SalesListService {
    SalesListDto addSalesList(SalesListDto salesListDto);
    void deleteSalesList(Long billNumber, Long itemId);
}
