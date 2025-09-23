package com.distributor.backend.repository;

import com.distributor.backend.entity.PurchaseList;
import com.distributor.backend.entity.PurchaseListId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseListRepository extends JpaRepository<PurchaseList, PurchaseListId> {
    @Query(value = "SELECT name, weight, company, max_retail_price, selling_price, quantity, discount, id FROM purchase_list as p, items as t WHERE p.item_id = t.id AND p.bill_number = ?1", nativeQuery = true)
    List<Object[]> findByBillNumber(Long billNumber);
}
