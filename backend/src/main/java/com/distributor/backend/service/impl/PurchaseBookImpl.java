package com.distributor.backend.service.impl;

import org.springframework.stereotype.Service;

import com.distributor.backend.entity.PurchaseBook;

import lombok.AllArgsConstructor;
import com.distributor.backend.dto.PurchaseBookDto;
import com.distributor.backend.entity.Driver;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.mapper.PurchaseBookMapper;
import com.distributor.backend.repository.DriverRepository;
import com.distributor.backend.repository.PurchaseBookRepository;
import com.distributor.backend.repository.SupplierRepository;
import com.distributor.backend.service.PurchaseBookService;
import com.distributor.backend.exception.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class PurchaseBookImpl implements PurchaseBookService {

    private PurchaseBookRepository purchaseBookRepository;
    private DriverRepository driverRepository;
    private SupplierRepository supplierRepository;

    @Override
    public PurchaseBookDto addPurchase(PurchaseBookDto purchaseBookDto) {
        Driver carrier = driverRepository.findById(purchaseBookDto.getCarrierLicenseNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with license number: " + purchaseBookDto.getCarrierLicenseNumber()));

    Supplier provider = supplierRepository.findById(purchaseBookDto.getProviderGstNumber())
        .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with GST Number: " + purchaseBookDto.getProviderGstNumber()));

        PurchaseBook purchaseBook = PurchaseBookMapper.maptoPurchaseBook(purchaseBookDto);
        purchaseBook.setCarrier(carrier);
        purchaseBook.setProvider(provider);

        PurchaseBook savedPurchaseBook = purchaseBookRepository.save(purchaseBook);

        return PurchaseBookMapper.maptoPurchaseBookDto(savedPurchaseBook);
    }

}
