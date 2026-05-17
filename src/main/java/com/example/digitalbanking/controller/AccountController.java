package com.example.digitalbanking.controller;

import com.example.digitalbanking.entity.Account;
import com.example.digitalbanking.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @PostMapping("/transfer")
    public String transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam Double amount) {

        return service.transferMoney(fromId, toId, amount);
    }
}