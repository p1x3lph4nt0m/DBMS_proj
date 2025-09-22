package com.distributor.backend.service;

import com.distributor.backend.dto.PurchaseBookDto;
import java.util.List;

public interface PurchaseBookService {
    PurchaseBookDto addPurchase(PurchaseBookDto purchaseBookDto);
    PurchaseBookDto getPurchaseByBillNumber(Long billNumber);
    List<PurchaseBookDto> getPurchasesByDateRangeAndGstPrefix(String startDate, String endDate, String gstPrefix);

}
