package com.distributor.backend.controller;

import com.distributor.backend.dto.PurchaseBookDto;
import com.distributor.backend.service.PurchaseBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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

    @GetMapping("/{billNumber}")
    public ResponseEntity<?> getPurchaseByBillNumber(@PathVariable Long billNumber) {
         PurchaseBookDto purchase = purchaseBookService.getPurchaseByBillNumber(billNumber);

        if (purchase != null) {
            return new ResponseEntity<>(purchase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bill number " + billNumber + " does not exist.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<PurchaseBookDto>> getPurchasesByDateRangeAndGstPrefix(
            @RequestParam String start_date,
            @RequestParam String end_date,
            @RequestParam String gst) {
        List<PurchaseBookDto> purchases = purchaseBookService.getPurchasesByDateRangeAndGstPrefix(start_date, end_date, gst);
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

}

