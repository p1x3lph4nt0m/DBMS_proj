package com.distributor.backend.service.impl;

import com.distributor.backend.dto.LoansTakenDto;
import com.distributor.backend.entity.LoansTaken;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.LoansTakenMapper;
import com.distributor.backend.repository.LoansTakenRepository;
import com.distributor.backend.repository.SupplierRepository;
import com.distributor.backend.service.LoansTakenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoansTakenServiceImpl implements LoansTakenService {
    private LoansTakenRepository loansTakenRepository;
    private static SupplierRepository supplierRepository;
    @Autowired
    public LoansTakenServiceImpl(SupplierRepository supplierRepository) {
        LoansTakenServiceImpl.supplierRepository = supplierRepository;
    }
    @Override
    public LoansTakenDto takeLoan(LoansTakenDto loansTakenDto) {
        Supplier supplier = supplierRepository.findById(loansTakenDto.getGstNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Supplier does not exist with the gst number: "+ loansTakenDto.getGstNumber())
                );
        LoansTaken taken = LoansTakenMapper.maptoLoansTaken(loansTakenDto, supplier);
        LoansTaken savedLoanTaken = loansTakenRepository.save(taken);
        return LoansTakenMapper.maptoLoansTakenDto(savedLoanTaken);
    }
}
