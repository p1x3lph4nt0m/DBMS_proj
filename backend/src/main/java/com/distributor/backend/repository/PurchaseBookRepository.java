package com.distributor.backend.repository;

import com.distributor.backend.entity.PurchaseBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseBookRepository extends JpaRepository<PurchaseBook,Long> {
}
