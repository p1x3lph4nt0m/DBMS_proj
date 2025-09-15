package com.distributor.backend.mapper;

import com.distributor.backend.dto.BuyerDto;
import com.distributor.backend.dto.SupplierDto;
import com.distributor.backend.entity.Buyer;
import com.distributor.backend.entity.Supplier;

public class BuyerMapper {
    private static BuyerDto maptoBuyerDto(Buyer buyer){
        return new BuyerDto(
                buyer.getGstNumber(),
                buyer.getPhoneNumber(),
                buyer.getName(),
                buyer.getEmail(),
                buyer.getBuildingName(),
                buyer.getArea(),
                buyer.getCity(),
                buyer.getZipCode()
        );
    }

    private static Buyer maptoBuyer(BuyerDto buyerDto){
        return new Buyer(
                buyerDto.getGstNumber(),
                buyerDto.getPhoneNumber(),
                buyerDto.getName(),
                buyerDto.getEmail(),
                buyerDto.getBuildingName(),
                buyerDto.getArea(),
                buyerDto.getCity(),
                buyerDto.getZipCode()
        );
    }
}
