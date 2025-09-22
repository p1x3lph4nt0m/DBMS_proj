package com.distributor.backend.repository;

import com.distributor.backend.entity.LoansGiven;
import com.distributor.backend.entity.LoansGivenId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoansGivenRepository extends JpaRepository<LoansGiven, LoansGivenId> {
    @Query("SELECT MAX(l.Id) FROM LoansGiven l WHERE l.buyer.gst = :gst")
    Long findMaxIdByBuyer(@Param("gst") String gst);
}