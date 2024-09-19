package com.example.senai.service;


import com.example.senai.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account getAccount(UUID id);

    Page<Account> getAllAccount(Pageable page, Specification<Account> spec);

    List<Account> saveAccount(List<Account> accounts);

    Account updateAccount(UUID id, Account account);

    void deleteAccount(UUID id);

}
