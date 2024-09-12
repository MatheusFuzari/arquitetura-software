package com.example.senai.repository;

import com.example.senai.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccontRepository extends JpaRepository<Account, UUID> {
}
