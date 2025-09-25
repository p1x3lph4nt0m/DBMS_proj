package com.distributor.backend.mapper;

import com.distributor.backend.dto.LoansGivenDto;
import com.distributor.backend.entity.LoansGiven;
import com.distributor.backend.entity.Buyer;

public class LoansGivenMapper {
    public static LoansGivenDto maptoLoansGivenDto(LoansGiven loansGiven){
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
    public static LoansGiven maptoLoansGiven(LoansGivenDto loansGivenDto, Buyer buyer){
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
