package com.distributor.backend.repository;

import com.distributor.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String> {
    Optional<Users> findByUsername(String username);
}
