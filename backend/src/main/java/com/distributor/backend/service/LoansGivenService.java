package com.distributor.backend.service;

import com.distributor.backend.dto.LoansGivenDto;

import java.util.List;

public interface LoansGivenService {
    LoansGivenDto giveLoan(LoansGivenDto loansGivenDto);
    List<LoansGivenDto> allLoans();
    void deleteLoan(Long id, String gst);
}