package com.distributor.backend.repository;

import com.distributor.backend.entity.SalesBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesBookRepository extends JpaRepository<SalesBook,Long> {
}
