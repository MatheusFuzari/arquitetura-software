package com.example.senai.service.impl;

import com.example.senai.entity.Account;
import com.example.senai.repository.AccontRepository;
import com.example.senai.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccontRepository accontRepository;

    @Override
    public Account getAccount(UUID id) {
        Optional<Account> optionalAccount = this.accontRepository.findById(id);
        if(optionalAccount.isPresent()){
            return optionalAccount.get();
        }
        return null;
    }

    @Override
    public Page<Account> getAllAccount(Pageable page, Specification<Account> spec) {
        return this.accontRepository.findAll(spec, page);
    }

    @Override
    public List<Account> saveAccount(List<Account> accounts) {
        return this.accontRepository.saveAll(accounts);
    }

    @Override
    public Account updateAccount(UUID id, Account account) {
        Optional<Account> optionalAccount = this.accontRepository.findById(id);

        if(optionalAccount.isPresent()){
            BeanUtils.copyProperties(account, optionalAccount);
            return this.accontRepository.save(optionalAccount.get());
        }

        return null;
    }

    @Override
    public void deleteAccount(UUID id) {
        Optional<Account> optionalAccount = this.accontRepository.findById(id);
        if(optionalAccount.isPresent()) {
            this.accontRepository.delete(optionalAccount.get());
        }
    }
}
