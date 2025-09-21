package com.distributor.backend.mapper;

import com.distributor.backend.dto.SupplierDto;
import com.distributor.backend.entity.Supplier;

public class SupplierMapper {
    public static SupplierDto maptoSupplierDto(Supplier supplier){
        return new SupplierDto(
                supplier.getGst(),
                supplier.getPhone(),
                supplier.getName(),
                supplier.getEmail(),
                supplier.getBuilding(),
                supplier.getArea(),
                supplier.getCity(),
                supplier.getZip()
        );
    }

    public static Supplier maptoSupplier(SupplierDto supplierDto){
        return new Supplier(
                supplierDto.getGst(),
                supplierDto.getPhone(),
                supplierDto.getName(),
                supplierDto.getEmail(),
                supplierDto.getBuilding(),
                supplierDto.getArea(),
                supplierDto.getCity(),
                supplierDto.getZip()
        );
    }
}
