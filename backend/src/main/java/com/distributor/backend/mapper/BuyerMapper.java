package com.distributor.backend.mapper;

import com.distributor.backend.dto.BuyerDto;
import com.distributor.backend.entity.Buyer;

public class BuyerMapper {
    public static BuyerDto maptoBuyerDto (Buyer buyer){
        return new BuyerDto(
                buyer.getGst(),
                buyer.getPhone(),
                buyer.getName(),
                buyer.getEmail(),
                buyer.getBuilding(),
                buyer.getArea(),
                buyer.getCity(),
                buyer.getZip()
        );
    }

    public static Buyer maptoBuyer(BuyerDto buyerDto){
        return new Buyer(
                buyerDto.getGst(),
                buyerDto.getPhone(),
                buyerDto.getName(),
                buyerDto.getEmail(),
                buyerDto.getBuilding(),
                buyerDto.getArea(),
                buyerDto.getCity(),
                buyerDto.getZip()
        );
    }
}
