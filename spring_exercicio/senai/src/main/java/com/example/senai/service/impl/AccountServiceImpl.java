package com.example.senai.service.impl;

import com.example.senai.entity.AccountToken;
import com.example.senai.service.AccountTokenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountTokenService {

    @Override
    public Page<AccountToken> getAllAccountTokens(Pageable page, Specification<AccountToken> spec) {
        return null;
    }

    @Override
    public List<AccountToken> saveAccountTokens(List<AccountToken> tokens) {
        return List.of();
    }

    @Override
    public AccountToken updateAccountToken(AccountToken accountToken) {
        return null;
    }

    @Override
    public void deleteAccountToken(UUID id) {

    }
}
