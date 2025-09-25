package com.distributor.backend.controller;

import com.distributor.backend.dto.SalesBookDto;
import com.distributor.backend.service.SalesBookService;
import lombok.AllArgsConstructor;

import java.util.List;

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

    @GetMapping("/{billNumber}")
    public ResponseEntity<?> getSalesByBillNumber(@PathVariable Long billNumber) {
        SalesBookDto sale = salesBookService.getSalesByBillNumber(billNumber);

        if (sale != null) {
            return new ResponseEntity<>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bill number " + billNumber + " does not exist.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search") 
    public ResponseEntity<List<SalesBookDto>> getSalesByDateRangeAndGstPrefix(
            @RequestParam String start_date,
            @RequestParam String end_date,
            @RequestParam String gst) {
        List<SalesBookDto> sales = salesBookService.getSalesByDateRangeAndGstPrefix(start_date, end_date, gst);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

}

