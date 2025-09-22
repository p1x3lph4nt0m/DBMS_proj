package com.distributor.backend.service;

import com.distributor.backend.dto.LoansTakenDto;

import java.util.List;

public interface LoansTakenService {
    LoansTakenDto takeLoan(LoansTakenDto loansTakenDto);
    List<LoansTakenDto> allLoans();
    void deleteLoan(Long id, String gst);
}