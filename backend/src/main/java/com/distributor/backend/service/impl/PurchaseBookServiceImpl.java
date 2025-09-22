package com.distributor.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import com.distributor.backend.dto.PurchaseBookDto;
import com.distributor.backend.entity.Driver;
import com.distributor.backend.entity.PurchaseBook;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.PurchaseBookMapper;
import com.distributor.backend.repository.DriverRepository;
import com.distributor.backend.repository.PurchaseBookRepository;
import com.distributor.backend.repository.SupplierRepository;
import com.distributor.backend.service.PurchaseBookService;

@Service
@AllArgsConstructor
public class PurchaseBookServiceImpl implements PurchaseBookService {

    private final PurchaseBookRepository purchaseBookRepository;
    private final DriverRepository driverRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public PurchaseBookDto addPurchase(PurchaseBookDto purchaseBookDto) {
        // Fetch related Driver
        Driver carrier = driverRepository.findById(purchaseBookDto.getCarrier())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Driver not found with license number: " + purchaseBookDto.getCarrier()));

        // Fetch related Supplier
        Supplier provider = supplierRepository.findById(purchaseBookDto.getProvider())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Supplier not found with GST Number: " + purchaseBookDto.getProvider()));

        // Check if PurchaseBook with this bill_number already exists
        PurchaseBook purchaseBook = purchaseBookRepository.findById(purchaseBookDto.getBill_number())
                .map(existing -> {
                    // Update existing entry
                    existing.setOrder_day(purchaseBookDto.getOrder_day());
                    existing.setOrder_month(purchaseBookDto.getOrder_month());
                    existing.setOrder_year(purchaseBookDto.getOrder_year());
                    existing.setCarrier(carrier);
                    existing.setProvider(provider);
                    return existing;
                })
                .orElseGet(() -> {
                    // Create new entry
                    PurchaseBook newBook = PurchaseBookMapper.maptoPurchaseBook(purchaseBookDto);
                    newBook.setCarrier(carrier);
                    newBook.setProvider(provider);
                    return newBook;
                });

        PurchaseBook saved = purchaseBookRepository.save(purchaseBook);
        return PurchaseBookMapper.maptoPurchaseBookDto(saved);
    }

    @Override
    public PurchaseBookDto getPurchaseByBillNumber(Long billNumber) {
        return purchaseBookRepository.findById(billNumber)
                .map(PurchaseBookMapper::maptoPurchaseBookDto)
                .orElse(null);
    }

    @Override
    public List<PurchaseBookDto> getPurchasesByDateRangeAndGstPrefix(String startDate, String endDate, String gstPrefix) {
        List<PurchaseBook> purchases = purchaseBookRepository.findInDateRangeWithGstNative(startDate, endDate, gstPrefix);
        return purchases.stream()
                .map(PurchaseBookMapper::maptoPurchaseBookDto)
                .toList();
    }

}
