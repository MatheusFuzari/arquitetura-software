package com.example.senai.service;


import com.example.senai.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Page<Account> getAllAccountTokens(Pageable page, Specification<Account> spec);

    List<Account> saveAccountTokens(List<Account> accounts);

    Account updateAccountToken(Account account);

    void deleteAccountToken(UUID id);

}
