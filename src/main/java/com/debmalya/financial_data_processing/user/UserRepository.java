package com.debmalya.financial_data_processing.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,UUID>{
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
