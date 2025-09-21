package com.distributor.backend.service.impl;

import org.springframework.stereotype.Service;
import com.distributor.backend.dto.SupplierDto;
import com.distributor.backend.entity.Supplier;
import com.distributor.backend.mapper.SupplierMapper;
import com.distributor.backend.repository.SupplierRepository;
import com.distributor.backend.service.SupplierService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService{
    
    private SupplierRepository supplierRepository;

    @Override
    public SupplierDto addSupplier(SupplierDto supplierDto) {
        Supplier supplier = SupplierMapper.maptoSupplier(supplierDto);
        Supplier savedSupplier= supplierRepository.save(supplier);
        return SupplierMapper.maptoSupplierDto(savedSupplier);
    }

}
