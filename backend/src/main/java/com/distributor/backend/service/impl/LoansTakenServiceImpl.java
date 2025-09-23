package com.distributor.backend.service.impl;

import com.distributor.backend.dto.LoansTakenDto;
import com.distributor.backend.entity.LoansTaken;
import com.distributor.backend.entity.LoansTakenId;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.LoansTakenMapper;
import com.distributor.backend.repository.LoansTakenRepository;
import com.distributor.backend.repository.SupplierRepository;
import com.distributor.backend.service.LoansTakenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoansTakenServiceImpl implements LoansTakenService {

    private final LoansTakenRepository loansTakenRepository;
    private final SupplierRepository supplierRepository;

    public LoansTakenServiceImpl(LoansTakenRepository loansTakenRepository,
                                 SupplierRepository supplierRepository) {
        this.loansTakenRepository = loansTakenRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public LoansTakenDto takeLoan(LoansTakenDto loansTakenDto) {
        Supplier supplier = supplierRepository.findById(loansTakenDto.getGstNumber())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Supplier does not exist with gst: " + loansTakenDto.getGstNumber()
                ));

        Long maxId = loansTakenRepository.findMaxIdBySupplier(supplier.getGst());
        Long nextId = (maxId == null) ? 1L : maxId + 1;

        LoansTaken loan = LoansTakenMapper.maptoLoansTaken(loansTakenDto, supplier);
        loan.setId(nextId);

        LoansTaken savedLoan = loansTakenRepository.save(loan);
        return LoansTakenMapper.maptoLoansTakenDto(savedLoan);
    }

    @Override
    public List<LoansTakenDto> allLoans() {
        return loansTakenRepository.findAll()
                .stream()
                .map(LoansTakenMapper::maptoLoansTakenDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLoan(Long id, String gst) {
        LoansTakenId loansTakenId = new LoansTakenId(id, gst);
        if (!loansTakenRepository.existsById(loansTakenId)) {
            throw new ResourceNotFoundException("Loan not found for id: " + id + " and gst: " + gst);
        }
        loansTakenRepository.deleteById(loansTakenId);
    }



}
