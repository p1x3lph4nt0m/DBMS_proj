package com.distributor.backend.controller;

import com.distributor.backend.dto.SalesBookDto;
import com.distributor.backend.service.SalesBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/sales-book")
public class SalesBookController{
    private final SalesBookService salesBookService;

    @PostMapping
    public ResponseEntity<SalesBookDto> addSales(@RequestBody SalesBookDto salesBookDto) {
        SalesBookDto savedSale = salesBookService.addSales(salesBookDto);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }
}

// {
//   "bill_number": 1001,
//   "order_day": 21,
//   "order_month": 9,
//   "order_year": 2025,
//   "carrier": "DL12345",
//   "customer": "GSTBUY002"
// }
