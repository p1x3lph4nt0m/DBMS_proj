package com.distributor.backend.repository;

import com.distributor.backend.entity.PurchaseBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PurchaseBookRepository extends JpaRepository<PurchaseBook,Long> {
    @Query(value = "SELECT * FROM purchase_book pb " +
               "JOIN supplier s ON pb.provider = s.gst " +
               "WHERE STR_TO_DATE(CONCAT(pb.order_year, '-', LPAD(pb.order_month, 2, '0'), '-', LPAD(pb.order_day, 2, '0')), '%Y-%m-%d') " +
               "BETWEEN :startDate AND :endDate " +
               "AND s.gst LIKE CONCAT(:gstPrefix, '%')", nativeQuery = true)
    List<PurchaseBook> findInDateRangeWithGstNative(@Param("startDate") String startDate,
                                                 @Param("endDate") String endDate,
                                                 @Param("gstPrefix") String gstPrefix);


}
