package com.distributor.backend.service;

import com.distributor.backend.dto.SalesBookDto;
import java.util.List;

public interface SalesBookService {
    SalesBookDto addSales(SalesBookDto salesBookDto);
    SalesBookDto getSalesByBillNumber(Long billNumber);
    List<SalesBookDto> getSalesByDateRangeAndGstPrefix(String startDate, String endDate, String gstPrefix);
}
