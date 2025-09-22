package com.distributor.backend.service;
import java.util.List;
import com.distributor.backend.dto.ItemsDto;

public interface ItemsService {
    ItemsDto addItem(ItemsDto itemDto);
    List<ItemsDto> getAllItems();
}
