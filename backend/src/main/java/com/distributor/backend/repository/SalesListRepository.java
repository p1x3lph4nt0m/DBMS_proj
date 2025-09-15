package com.distributor.backend.repository;

import com.distributor.backend.entity.SalesList;
import com.distributor.backend.entity.SalesListId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesListRepository extends JpaRepository<SalesList, SalesListId> {
}
