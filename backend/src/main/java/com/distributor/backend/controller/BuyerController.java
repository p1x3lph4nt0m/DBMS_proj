package com.distributor.backend.controller;

import com.distributor.backend.dto.BuyerDto;
import com.distributor.backend.service.BuyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/buyers")

public class BuyerController {

    private BuyerService buyerService;

    @PostMapping
    public ResponseEntity<BuyerDto> addBuyer(@RequestBody BuyerDto buyerDto) {
        BuyerDto savedBuyer = buyerService.addBuyer(buyerDto);
        return new ResponseEntity<>(savedBuyer, HttpStatus.CREATED);
    }

    @GetMapping("/all-gst")
    public ResponseEntity<List<String>> getAllBuyerGst() {
        List<String> gstNumbers = buyerService.getAllBuyerGst();
        return new ResponseEntity<>(gstNumbers, HttpStatus.OK);
    }
}
