package com.distributor.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distributor.backend.dto.SalesListDto;
import com.distributor.backend.service.SalesListService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping
public class SalesListController {

    private SalesListService salesListService;

    @PostMapping("/add")
    public ResponseEntity<SalesListDto> addSalesList(@RequestBody SalesListDto salesListDto) {
        SalesListDto savedSalesList = salesListService.addSalesList(salesListDto);
        return new ResponseEntity<>(savedSalesList, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{billNumber}/{itemId}")
    public ResponseEntity<String> deleteSalesList(@PathVariable Long billNumber, @PathVariable Long itemId) {
        salesListService.deleteSalesList(billNumber, itemId);
        return new ResponseEntity<>("SalesList entry deleted successfully", HttpStatus.OK);
    }
}
/*POST /purchaselist/add
Content-Type: application/json

{
  "bill_number": 101,
  "item_id": 5,
  "discount": 5.0,
  "quantity": 10
}*/