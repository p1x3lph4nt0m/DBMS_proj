package com.distributor.backend.controller;

import com.distributor.backend.dto.SupplierDto;
import com.distributor.backend.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/suppliers")
public class SupplierController {

     private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierDto> addSupplier(@RequestBody SupplierDto supplierDto) {
        SupplierDto savedSupplier = supplierService.addSupplier(supplierDto);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }
}
