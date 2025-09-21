package com.distributor.backend.service;

import com.distributor.backend.dto.SalesBookDto;

public interface SalesBookService {
    SalesBookDto addSales(SalesBookDto salesBookDto);
    SalesBookDto getSalesByBillNumber(Long billNumber);
}
