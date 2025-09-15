package com.distributor.backend.repository;

import com.distributor.backend.entity.PurchaseList;
import com.distributor.backend.entity.PurchaseListId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseListRepository extends JpaRepository<PurchaseList, PurchaseListId> {
}
