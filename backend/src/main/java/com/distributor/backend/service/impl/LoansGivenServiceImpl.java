package com.distributor.backend.service.impl;

import com.distributor.backend.dto.LoansGivenDto;
import com.distributor.backend.entity.LoansGiven;
import com.distributor.backend.entity.LoansGivenId;
import com.distributor.backend.entity.Buyer;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.LoansGivenMapper;
import com.distributor.backend.repository.LoansGivenRepository;
import com.distributor.backend.repository.BuyerRepository;
import com.distributor.backend.service.LoansGivenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoansGivenServiceImpl implements LoansGivenService {

    private final LoansGivenRepository loansGivenRepository;
    private final BuyerRepository buyerRepository;

    public LoansGivenServiceImpl(LoansGivenRepository loansGivenRepository,
                                 BuyerRepository buyerRepository) {
        this.loansGivenRepository = loansGivenRepository;
        this.buyerRepository = buyerRepository;
    }

    @Override
    public LoansGivenDto giveLoan(LoansGivenDto loansGivenDto) {
        Buyer buyer = buyerRepository.findById(loansGivenDto.getGstNumber())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Buyer does not exist with gst: " + loansGivenDto.getGstNumber()
                ));

        Long maxId = loansGivenRepository.findMaxIdByBuyer(buyer.getGst());
        Long nextId = (maxId == null) ? 1L : maxId + 1;

        LoansGiven loan = LoansGivenMapper.maptoLoansGiven(loansGivenDto, buyer);
        loan.setId(nextId);

        LoansGiven savedLoan = loansGivenRepository.save(loan);
        return LoansGivenMapper.maptoLoansGivenDto(savedLoan);
    }

    @Override
    public List<LoansGivenDto> allLoans() {
        return loansGivenRepository.findAll()
                .stream()
                .map(LoansGivenMapper::maptoLoansGivenDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLoan(Long id, String gst) {
        LoansGivenId loansGivenId = new LoansGivenId(id, gst);
        if (!loansGivenRepository.existsById(loansGivenId)) {
            throw new ResourceNotFoundException("Loan not found for id: " + id + " and gst: " + gst);
        }
        loansGivenRepository.deleteById(loansGivenId);
    }

}
