package com.distributor.backend.mapper;

import com.distributor.backend.dto.LoansTakenDto;
import com.distributor.backend.entity.LoansTaken;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.repository.SupplierRepository;

public class LoansTakenMapper {
    private static SupplierRepository supplierRepository;
    private static LoansTakenDto maptoLoansTakenDto(LoansTaken loansTaken){
        return new LoansTakenDto(
                loansTaken.getId(),
                loansTaken.getRate(),
                loansTaken.getAmt(),
                loansTaken.getDay(),
                loansTaken.getMonth(),
                loansTaken.getYear(),
                loansTaken.getDuration(),
                loansTaken.getSupplier().getGstNumber(),
                loansTaken.getSupplier().getName()
        );
    }
    private static LoansTaken maptoLoansTaken(LoansTakenDto loansTakenDto){
        Supplier supplier = supplierRepository.findById(loansTakenDto.getGstNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Supplier does not exist with the gst number: "+ loansTakenDto.getGstNumber())
                );
        return new LoansTaken(
                loansTakenDto.getId(),
                loansTakenDto.getRate(),
                loansTakenDto.getAmt(),
                loansTakenDto.getDay(),
                loansTakenDto.getMonth(),
                loansTakenDto.getYear(),
                loansTakenDto.getDuration(),
                supplier
        );
    }
}
