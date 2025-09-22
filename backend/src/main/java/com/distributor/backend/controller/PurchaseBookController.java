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

    @PostMapping // Add or Update a purchase entry
    public ResponseEntity<PurchaseBookDto> addPurchase(@RequestBody PurchaseBookDto purchaseBookDto) {
        PurchaseBookDto savedPurchase = purchaseBookService.addPurchase(purchaseBookDto);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    // Get details of a specific purchase by bill number
    @GetMapping("/{billNumber}")
    public ResponseEntity<?> getPurchaseByBillNumber(@PathVariable Long billNumber) {
         PurchaseBookDto purchase = purchaseBookService.getPurchaseByBillNumber(billNumber);

        if (purchase != null) {
            return new ResponseEntity<>(purchase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bill number " + billNumber + " does not exist.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search") // Get all purchase entries
    public ResponseEntity<List<PurchaseBookDto>> getPurchasesByDateRangeAndGstPrefix(
            @RequestParam String start_date,
            @RequestParam String end_date,
            @RequestParam String gst) {
        List<PurchaseBookDto> purchases = purchaseBookService.getPurchasesByDateRangeAndGstPrefix(start_date, end_date, gst);
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    // http://localhost:8080/purchase-book/search?start_date=2025-09-01&end_date=2025-09-21&gst=GSTIN
}

// {
//   "bill_number": 1001,
//   "order_day": 21,
//   "order_month": 9,
//   "order_year": 2025,
//   "carrier": "DL12345",

//   "provider": "GSTIN123456789"
// }
