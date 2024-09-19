package com.example.senai.repository;

import com.example.senai.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID>, JpaSpecificationExecutor<Token> {
}
