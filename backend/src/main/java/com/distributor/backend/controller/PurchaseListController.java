package com.distributor.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distributor.backend.dto.PurchaseListDto;
import com.distributor.backend.service.PurchaseListService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/purchaselist")
public class PurchaseListController {

    private PurchaseListService purchaseListService;

    @PostMapping("/add")
    public ResponseEntity<PurchaseListDto> addPurchase(@RequestBody PurchaseListDto purchaseListDto) {
        PurchaseListDto savedPurchaseList = purchaseListService.addPurchaseList(purchaseListDto);
        return new ResponseEntity<>(savedPurchaseList, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{billNumber}/{itemId}")
    public ResponseEntity<String> deletePurchaseList(@PathVariable Long billNumber, @PathVariable Long itemId) {
        purchaseListService.deletePurchaseList(billNumber, itemId);
        return new ResponseEntity<>("PurchaseList entry deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/all/{billNumber}")
    public ResponseEntity<List<Object[]>> findByBillNumber(@PathVariable Long billNumber) {
      if (billNumber == null) {
        return ResponseEntity.badRequest().body(Collections.emptyList());
      }

      List<Object[]> rows = purchaseListService.findByBillNumber(billNumber);
      if (rows == null || rows.isEmpty()) {
        return ResponseEntity.ok(Collections.emptyList());
      }
      return ResponseEntity.ok(rows);
    }    
}
