package com.distributor.backend.service.impl;

import org.springframework.stereotype.Service;
import com.distributor.backend.dto.BuyerDto;
import com.distributor.backend.entity.Buyer;
import com.distributor.backend.mapper.BuyerMapper;
import com.distributor.backend.repository.BuyerRepository;
import com.distributor.backend.service.BuyerService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepository buyerRepository;
    
    @Override
    public BuyerDto addBuyer(BuyerDto buyerDto) {
        Buyer buyer = BuyerMapper.maptoBuyer(buyerDto);
        Buyer savedBuyer = buyerRepository.save(buyer);
        return BuyerMapper.maptoBuyerDto(savedBuyer);
    }
}
