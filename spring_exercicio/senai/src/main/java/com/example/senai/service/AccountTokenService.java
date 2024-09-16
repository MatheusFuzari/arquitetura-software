package com.example.senai.service;

import com.example.senai.entity.AccountToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface AccountTokenService {

    Page<AccountToken> getAllAccountTokens(Pageable page, Specification<AccountToken> spec);

    List<AccountToken> saveAccountTokens(List<AccountToken> tokens);

    AccountToken updateAccountToken(AccountToken accountToken);

    void deleteAccountToken(UUID id);
}
