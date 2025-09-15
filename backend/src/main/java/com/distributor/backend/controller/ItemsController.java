package com.distributor.backend.controller;

import com.distributor.backend.dto.ItemsDto;
import com.distributor.backend.service.ItemsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
