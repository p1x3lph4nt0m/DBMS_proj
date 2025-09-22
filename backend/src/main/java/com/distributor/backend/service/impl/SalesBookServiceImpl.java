package com.distributor.backend.service.impl;

import java.util.List;

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

    private final SalesBookRepository salesBookRepository;
    private final DriverRepository driverRepository;
    private final BuyerRepository buyerRepository;

    @Override
    public SalesBookDto addSales(SalesBookDto salesBookDto) {
        // Fetch related Driver
        Driver carrier = driverRepository.findById(salesBookDto.getCarrier())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Driver not found with license number: " + salesBookDto.getCarrier()));

        // Fetch related Buyer
        Buyer customer = buyerRepository.findById(salesBookDto.getCustomer())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found with GST number: " + salesBookDto.getCustomer()));

        // Check if SalesBook with this bill number already exists
        SalesBook salesBook = salesBookRepository.findById(salesBookDto.getBill_number())
                .map(existing -> {
                    // Update existing entry
                    existing.setOrder_day(salesBookDto.getOrder_day());
                    existing.setOrder_month(salesBookDto.getOrder_month());
                    existing.setOrder_year(salesBookDto.getOrder_year());
                    existing.setCarrier(carrier);
                    existing.setCustomer(customer);
                    return existing;
                })
                .orElseGet(() -> {
                    // Create new entry
                    SalesBook newSales = SalesBookMapper.maptoSalesBook(salesBookDto);
                    newSales.setCarrier(carrier);
                    newSales.setCustomer(customer);
                    return newSales;
                });

        SalesBook savedSalesBook = salesBookRepository.save(salesBook);
        return SalesBookMapper.maptosalesBookDto(savedSalesBook);
    }

    @Override
    public SalesBookDto getSalesByBillNumber(Long billNumber) {
        return salesBookRepository.findById(billNumber)
                .map(SalesBookMapper::maptosalesBookDto)
                .orElse(null);
    }

    @Override
    public List<SalesBookDto> getSalesByDateRangeAndGstPrefix(String startDate, String endDate, String gstPrefix) {
        List<SalesBook> sales = salesBookRepository.findInDateRangeWithGstNative(startDate, endDate, gstPrefix);
        return sales.stream()
                .map(SalesBookMapper::maptosalesBookDto)
                .toList();
    }

    
}
