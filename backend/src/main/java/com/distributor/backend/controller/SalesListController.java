package com.distributor.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.distributor.backend.dto.SalesListDto;
import com.distributor.backend.service.SalesListService;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/saleslist")
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

    @GetMapping("/all/{billNumber}")
    public ResponseEntity<List<Object[]>> findByBillNumber(@PathVariable Long billNumber) {
        if (billNumber == null) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        List<Object[]> rows = salesListService.findByBillNumber(billNumber);
        if (rows == null || rows.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(rows);
    }
}
/*POST /purchaselist/add
Content-Type: application/json

{
  "bill_number": 101,
  "item_id": 5,
  "discount": 5.0,
  "quantity": 10
}
{
  "bill_number": 101,
  "item_id": 5,
  "discount": 5.0,
  "quantity": 5
}
{
  "bill_number": 11,
  "item_id": 2,
  "discount": 5.0,
  "quantity": 1000
}  
*/