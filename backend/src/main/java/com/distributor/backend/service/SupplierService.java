package com.distributor.backend.service;

import com.distributor.backend.dto.SupplierDto;
import java.util.List;

public interface SupplierService {
    SupplierDto addSupplier(SupplierDto supplierDto);
    List<String> getAllSupplierGst();
}
