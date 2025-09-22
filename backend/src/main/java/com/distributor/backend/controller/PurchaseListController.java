package com.distributor.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
}

/*POST /purchaselist/add
Content-Type: application/json

{
  "bill_number": 101,
  "item_id": 5,
  "discount": 5.0,
  "quantity": 10
}*/
