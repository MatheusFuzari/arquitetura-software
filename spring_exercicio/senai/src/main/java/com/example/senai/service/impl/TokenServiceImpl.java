package com.example.senai.service.impl;

import com.example.senai.entity.Token;
import com.example.senai.service.TokenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public Page<Token> getAllTokens(Pageable page, Specification<Token> spec) {
        return null;
    }

    @Override
    public List<Token> saveTokens(List<Token> tokens) {
        return List.of();
    }

    @Override
    public Token updateToken(Token token) {
        return null;
    }

    @Override
    public void deleteToken(UUID id) {

    }
}
