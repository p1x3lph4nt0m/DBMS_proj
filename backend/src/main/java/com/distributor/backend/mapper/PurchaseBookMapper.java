package com.distributor.backend.mapper;

import com.distributor.backend.dto.PurchaseBookDto;
import com.distributor.backend.entity.Driver;
import com.distributor.backend.entity.PurchaseBook;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.repository.DriverRepository;
import com.distributor.backend.repository.SupplierRepository;

public class PurchaseBookMapper {
    public static DriverRepository driverRepository;
    public static SupplierRepository supplierRepository;
    public static PurchaseBookDto maptoPurchaseBookDto(PurchaseBook purchaseBook){
        return new PurchaseBookDto(
                purchaseBook.getBillNumber(),
                purchaseBook.getOrderDay(),
                purchaseBook.getOrderMonth(),
                purchaseBook.getOrderYear(),
                purchaseBook.getCarrier().getLicenseNumber(),
                purchaseBook.getProvider().getGstNumber()
        );
    }
    public static PurchaseBook maptoPurchaseBook(PurchaseBookDto purchaseBookDto){
        Driver driver = driverRepository.findById(purchaseBookDto.getCarrierLicenseNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Driver does not exist with the given License number:" + purchaseBookDto.getCarrierLicenseNumber())
                );
        Supplier supplier = supplierRepository.findById(purchaseBookDto.getProviderGstNumber())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Supplier not found with given GST Number: " + purchaseBookDto.getProviderGstNumber())
                );
        return new PurchaseBook(
                purchaseBookDto.getBillNumber(),
                purchaseBookDto.getOrderDay(),
                purchaseBookDto.getOrderMonth(),
                purchaseBookDto.getOrderYear(),
                driver,
                supplier
        );
    }
}
