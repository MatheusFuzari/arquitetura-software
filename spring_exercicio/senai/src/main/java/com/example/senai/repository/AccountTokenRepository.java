package com.example.senai.repository;

import com.example.senai.entity.AccountToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountTokenRepository extends JpaRepository<AccountToken, UUID> {
}
