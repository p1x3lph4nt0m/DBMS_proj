package com.distributor.backend.controller;

import com.distributor.backend.dto.ItemsDto;
import com.distributor.backend.service.ItemsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemsController {
    private ItemsService itemsService;

    @PostMapping
    public ResponseEntity<ItemsDto> addItem(@RequestBody ItemsDto itemsDto){
        ItemsDto savedItem = itemsService.addItem(itemsDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemsDto>> getAllItems() {
        List<ItemsDto> items = itemsService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
