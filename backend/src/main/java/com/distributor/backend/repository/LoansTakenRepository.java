package com.distributor.backend.repository;

import com.distributor.backend.entity.LoansTaken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansTakenRepository extends JpaRepository<LoansTaken,String> {
}