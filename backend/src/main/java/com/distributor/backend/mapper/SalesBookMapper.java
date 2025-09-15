package com.distributor.backend.mapper;

import com.distributor.backend.dto.SalesBookDto;
import com.distributor.backend.entity.Buyer;
import com.distributor.backend.entity.Driver;
import com.distributor.backend.entity.SalesBook;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.repository.BuyerRepository;
import com.distributor.backend.repository.DriverRepository;
import com.distributor.backend.repository.SalesBookRepository;

public class SalesBookMapper {
    public static DriverRepository driverRepository;
    public static BuyerRepository buyerRepository;
    public static SalesBookDto maptosalesBookDto(SalesBook salesbook){
        return new SalesBookDto(
                salesbook.getBillNumber(),
                salesbook.getOrderDay(),
                salesbook.getOrderMonth(),
                salesbook.getOrderYear(),
                salesbook.getCarrier().getLicenseNumber(),
                salesbook.getCustomer().getGstNumber()
        );
    }
    public static SalesBook maptoSalesBook(SalesBookDto salesBookDto){
        Driver driver = driverRepository.findById(salesBookDto.getCarrierLicenseNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Supplier does not exist with the gst number: "+ salesBookDto.getCarrierLicenseNumber())
                );
        Buyer buyer = buyerRepository.findById(salesBookDto.getCustomerGstNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Supplier does not exist with the gst number: "+ salesBookDto.getCustomerGstNumber())
                );
        return new SalesBook(
                salesBookDto.getBillNumber(),
                salesBookDto.getOrderDay(),
                salesBookDto.getOrderMonth(),
                salesBookDto.getOrderYear(),
                driver,
                buyer
        );
    }
}
