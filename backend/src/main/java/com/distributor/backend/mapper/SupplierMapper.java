package com.distributor.backend.mapper;

import com.distributor.backend.dto.SupplierDto;
import com.distributor.backend.entity.Supplier;

public class SupplierMapper {
    public static SupplierDto maptoSupplierDto(Supplier supplier){
        return new SupplierDto(
                supplier.getGstNumber(),
                supplier.getPhoneNumber(),
                supplier.getName(),
                supplier.getEmail(),
                supplier.getBuildingName(),
                supplier.getArea(),
                supplier.getCity(),
                supplier.getZipCode()
        );
    }

    public static Supplier maptoSupplier(SupplierDto supplierDto){
        return new Supplier(
                supplierDto.getGstNumber(),
                supplierDto.getPhoneNumber(),
                supplierDto.getName(),
                supplierDto.getEmail(),
                supplierDto.getBuildingName(),
                supplierDto.getArea(),
                supplierDto.getCity(),
                supplierDto.getZipCode()
        );
    }
}
