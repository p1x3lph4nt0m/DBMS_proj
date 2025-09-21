package com.distributor.backend.service.impl;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import com.distributor.backend.dto.SalesBookDto;
import com.distributor.backend.entity.Driver;
import com.distributor.backend.entity.Buyer;
import com.distributor.backend.entity.SalesBook;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.SalesBookMapper;
import com.distributor.backend.repository.DriverRepository;
import com.distributor.backend.repository.BuyerRepository;
import com.distributor.backend.repository.SalesBookRepository;
import com.distributor.backend.service.SalesBookService;

@Service
@AllArgsConstructor
public class SalesBookServiceImpl implements SalesBookService {

    private  SalesBookRepository salesBookRepository;
    private  DriverRepository driverRepository;
    private  BuyerRepository buyerRepository;

    @Override
    public SalesBookDto addSales(SalesBookDto salesBookDto) {
        // Fetch Driver entity by license number
        Driver carrier = driverRepository.findById(salesBookDto.getCarrierLicenseNumber())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Driver not found with license number: " + salesBookDto.getCarrierLicenseNumber()));

        // Fetch Buyer entity by GST number
        Buyer customer = buyerRepository.findById(salesBookDto.getCustomerGstNumber())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found with GST number: " + salesBookDto.getCustomerGstNumber()));

        // Map DTO to entity (without carrier and customer set yet)
        SalesBook salesBook = SalesBookMapper.maptoSalesBook(salesBookDto);

        // Set the fetched entities
        salesBook.setCarrier(carrier);
        salesBook.setCustomer(customer);

        // Save the salesBook entity
        SalesBook savedSalesBook = salesBookRepository.save(salesBook);

        // Map saved entity to DTO and return
        return SalesBookMapper.maptosalesBookDto(savedSalesBook);
    }
}
