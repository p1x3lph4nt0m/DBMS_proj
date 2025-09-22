package com.distributor.backend.repository;

import com.distributor.backend.entity.LoansTaken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoansTakenRepository extends JpaRepository<LoansTaken,Long> {
    @Query("SELECT MAX(l.Id) FROM LoansTaken l WHERE l.supplier.gst = :gst")
    Long findMaxIdBySupplier(@Param("gst") String gst);
}