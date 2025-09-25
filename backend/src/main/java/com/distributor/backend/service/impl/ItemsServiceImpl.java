package com.distributor.backend.service.impl;

import com.distributor.backend.dto.ItemsDto;
import com.distributor.backend.entity.Items;
import com.distributor.backend.mapper.ItemsMapper;
import com.distributor.backend.repository.ItemsRepository;
import com.distributor.backend.service.ItemsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemsServiceImpl implements ItemsService {

    private ItemsRepository itemsRepository;

    @Override
    public ItemsDto addItem(ItemsDto itemDto) {
        Items item = ItemsMapper.maptoItems(itemDto);
        Items savedItem = itemsRepository.save(item);
        return ItemsMapper.maptoItemsDto(savedItem);
    }

    @Override
    public List<ItemsDto> getAllItems() {
        return itemsRepository.findAll()
            .stream()
            .map(ItemsMapper::maptoItemsDto)
            .collect(Collectors.toList());
    }
}
