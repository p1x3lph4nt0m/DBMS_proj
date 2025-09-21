package com.distributor.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.distributor.backend.dto.DriverDto;
import com.distributor.backend.service.DriverService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/drivers")
public class DriverController {
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<DriverDto> addDriver(@RequestBody DriverDto driverDto) {
        DriverDto savedDriver = driverService.addDriver(driverDto);
        return new ResponseEntity<>(savedDriver, HttpStatus.CREATED);
    }

}
