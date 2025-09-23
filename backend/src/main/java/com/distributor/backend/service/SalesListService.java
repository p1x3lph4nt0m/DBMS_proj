package com.distributor.backend.service;

import com.distributor.backend.dto.SalesListDto;

import java.util.List;

public interface SalesListService {
    SalesListDto addSalesList(SalesListDto salesListDto);
    void deleteSalesList(Long billNumber, Long itemId);
    List<Object[]> findByBillNumber(Long billNumber);
}
