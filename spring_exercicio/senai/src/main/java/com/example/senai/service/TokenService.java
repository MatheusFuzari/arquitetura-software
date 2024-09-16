package com.example.senai.service;

import com.example.senai.entity.Token;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface TokenService {

    Page<Token> getAllTokens(Pageable page, Specification<Token> spec);

    List<Token> saveTokens(List<Token> tokens);

    Token updateToken(Token token);

    void deleteToken(UUID id);
}
