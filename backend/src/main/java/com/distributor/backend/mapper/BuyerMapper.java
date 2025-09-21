package com.distributor.backend.mapper;

import com.distributor.backend.dto.BuyerDto;
import com.distributor.backend.entity.Buyer;

public class BuyerMapper {
    public static BuyerDto maptoBuyerDto (Buyer buyer){
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

    public static Buyer maptoBuyer(BuyerDto buyerDto){
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
