package com.example.digitalbanking.controller;

import com.example.digitalbanking.dto.AccountRequest;
import com.example.digitalbanking.dto.AccountResponse;
import com.example.digitalbanking.dto.TransferRequest;
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
    public AccountResponse createAccount(@RequestBody AccountRequest request) {

        return service.createAccount(request);
    }

    @GetMapping
    public List<AccountResponse> getAllAccounts() {

        return service.getAllAccounts();
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestBody TransferRequest request) {

        return service.transferMoney(request);
    }
}