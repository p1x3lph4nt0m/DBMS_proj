package com.distributor.backend.mapper;

import com.distributor.backend.dto.ItemsDto;
import com.distributor.backend.entity.Items;

public class ItemsMapper {

    public static ItemsDto maptoItemsDto(Items items){
        return new ItemsDto(
                items.getId(),
                items.getName(),
                items.getTaxRate(),
                items.getCompany(),
                items.getQuantity(),
                items.getSp(),
                items.getMrp(),
                items.getWt()
        );
    }

    public static Items maptoItems(ItemsDto itemsDto){
        return new Items(
                itemsDto.getId(),
                itemsDto.getName(),
                itemsDto.getTaxRate(),
                itemsDto.getCompany(),
                itemsDto.getQuantity(),
                itemsDto.getSp(),
                itemsDto.getMrp(),
                itemsDto.getWt()
        );
    }
}
