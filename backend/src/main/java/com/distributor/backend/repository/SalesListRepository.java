package com.distributor.backend.repository;

import com.distributor.backend.entity.SalesList;
import com.distributor.backend.entity.SalesListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesListRepository extends JpaRepository<SalesList, SalesListId> {
    @Query(value = "SELECT name, weight, company, max_retail_price, selling_price, quantity, discount, id FROM sales_list as p, items as t WHERE p.item_id = t.id AND p.bill_number = ?1", nativeQuery = true)
    List<Object[]> findByBillNumber(Long billNumber);
}
