package com.distributor.backend.repository;

import com.distributor.backend.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer,String> {
}