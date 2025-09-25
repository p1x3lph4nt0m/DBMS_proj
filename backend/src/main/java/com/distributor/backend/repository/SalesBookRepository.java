package com.distributor.backend.repository;

import com.distributor.backend.entity.SalesBook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalesBookRepository extends JpaRepository<SalesBook,Long> {
    @Query(value = "SELECT * FROM sales_book sb " + "WHERE STR_TO_DATE(CONCAT(sb.order_year, '-', LPAD(sb.order_month, 2, '0'), '-', LPAD(sb.order_day, 2, '0')), '%Y-%m-%d') " + "BETWEEN :startDate AND :endDate " + "AND sb.customer LIKE CONCAT(:gstPrefix, '%')", nativeQuery = true)
    List<SalesBook> findInDateRangeWithGstNative(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("gstPrefix") String gstPrefix);
}
    