package com.distributor.backend.mapper;

import com.distributor.backend.dto.LoansGivenDto;
import com.distributor.backend.entity.Buyer;
import com.distributor.backend.entity.LoansGiven;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.repository.BuyerRepository;


public class LoansGivenMapper {
    private static BuyerRepository buyerRepository;
    private static LoansGivenDto maptoLoansGivenDto(LoansGiven loansGiven){
        return new LoansGivenDto(
                loansGiven.getId(),
                loansGiven.getRate(),
                loansGiven.getAmt(),
                loansGiven.getDay(),
                loansGiven.getMonth(),
                loansGiven.getYear(),
                loansGiven.getDuration(),
                loansGiven.getBuyer().getGst()
        );
    }
    private static LoansGiven maptoLoansGiven(LoansGivenDto loansGivenDto){
        Buyer buyer = buyerRepository.findById(loansGivenDto.getGstNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Buyer does not exist with the gst number: "+ loansGivenDto.getGstNumber())
                );
        return new LoansGiven(
                loansGivenDto.getId(),
                loansGivenDto.getRate(),
                loansGivenDto.getAmt(),
                loansGivenDto.getDay(),
                loansGivenDto.getMonth(),
                loansGivenDto.getYear(),
                loansGivenDto.getDuration(),
                buyer
        );
    }
}
