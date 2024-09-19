package com.example.senai.controller;

import com.example.senai.dto.AccountDTO;
import com.example.senai.dto.UserDTO;
import com.example.senai.entity.Account;
import com.example.senai.entity.AccountToken;
import com.example.senai.entity.User;
import com.example.senai.service.impl.AccountServiceImpl;
import com.example.senai.service.impl.UserServiceImpl;
import com.example.senai.specifications.AccountSpecifications;
import com.example.senai.specifications.UserSpecifications;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable UUID id){
        Account account = this.accountService.getAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @GetMapping("/accounts")
    public ResponseEntity<Page<Account>> getAllAccounts(Pageable page, AccountSpecifications.AccountSpec spec){
        Page<Account> accounts = this.accountService.getAllAccount(page, spec);
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @PostMapping("/accounts")
    public ResponseEntity<List<Account>> postAccount(@RequestBody @Valid List<AccountDTO> account){
        List<Account> AccountList = account.stream().map(dto -> {
            Account convertedAccount = new Account();
            BeanUtils.copyProperties(account, convertedAccount, "created_date");
            return convertedAccount;
        }).toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(this.accountService.saveAccount(AccountList));
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> putAccount(@PathVariable UUID id, @RequestBody @Valid AccountDTO account){
        Account convertedAccount = new Account();
        BeanUtils.copyProperties(account, convertedAccount, "created_date");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.accountService.updateAccount(id, convertedAccount));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable UUID id) {
        this.accountService.deleteAccount(id);
    }
}
