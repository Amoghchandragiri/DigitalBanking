package com.example.digitalbanking.repository;

import com.example.digitalbanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}