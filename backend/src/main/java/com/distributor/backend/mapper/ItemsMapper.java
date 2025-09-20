package com.distributor.backend.mapper;

import com.distributor.backend.dto.ItemsDto;
import com.distributor.backend.entity.Items;

public class ItemsMapper {

    public static ItemsDto maptoItemsDto(Items items){
        return new ItemsDto(
                items.getId(),
                items.getName(),
                items.getTax(),
                items.getCompany(),
                items.getStock(),
                items.getPrice(),
                items.getMrp(),
                items.getWeight()
        );
    }

    public static Items maptoItems(ItemsDto itemsDto){
        return new Items(
                itemsDto.getId(),
                itemsDto.getName(),
                itemsDto.getTax(),
                itemsDto.getCompany(),
                itemsDto.getStock(),
                itemsDto.getPrice(),
                itemsDto.getMrp(),
                itemsDto.getWeight()
        );
    }
}
