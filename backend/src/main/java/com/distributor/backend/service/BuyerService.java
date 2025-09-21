package com.distributor.backend.service;

import com.distributor.backend.dto.BuyerDto;
import java.util.List;

public interface BuyerService {
    BuyerDto addBuyer(BuyerDto buyerDto);
    List<String> getAllBuyerGst();
}
