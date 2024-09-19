package com.example.senai.repository;

import com.example.senai.entity.Account;
import com.example.senai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AccontRepository extends JpaRepository<Account, UUID>, JpaSpecificationExecutor<Account> {
}
