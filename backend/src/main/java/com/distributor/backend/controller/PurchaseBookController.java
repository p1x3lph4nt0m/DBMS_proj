package com.distributor.backend.controller;

import com.distributor.backend.dto.PurchaseBookDto;
import com.distributor.backend.service.PurchaseBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/purchase-book")
public class PurchaseBookController {

    private final PurchaseBookService purchaseBookService;

    @PostMapping
    public ResponseEntity<PurchaseBookDto> addPurchase(@RequestBody PurchaseBookDto purchaseBookDto) {
        PurchaseBookDto savedPurchase = purchaseBookService.addPurchase(purchaseBookDto);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }
}

// {
//   "bill_number": 1001,
//   "order_day": 21,
//   "order_month": 9,
//   "order_year": 2025,
//   "carrier": "DL12345",
//   "provider": "GSTIN123456789"
// }
