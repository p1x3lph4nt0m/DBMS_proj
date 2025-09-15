package com.distributor.backend.repository;

import com.distributor.backend.entity.LoansGiven;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansGivenRepository extends JpaRepository<LoansGiven,String> {
}