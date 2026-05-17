package com.example.digitalbanking.service;

import com.example.digitalbanking.dto.AccountRequest;
import com.example.digitalbanking.dto.AccountResponse;
import com.example.digitalbanking.dto.TransferRequest;
import com.example.digitalbanking.entity.Account;
import com.example.digitalbanking.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public AccountResponse createAccount(AccountRequest request) {

        Account account = new Account();

        account.setHolderName(request.getHolderName());
        account.setBalance(request.getBalance());

        Account saved = repository.save(account);

        return new AccountResponse(
                saved.getId(),
                saved.getHolderName(),
                saved.getBalance()
        );
    }

    public List<AccountResponse> getAllAccounts() {

        return repository.findAll()
                .stream()
                .map(account -> new AccountResponse(
                        account.getId(),
                        account.getHolderName(),
                        account.getBalance()
                ))
                .collect(Collectors.toList());
    }

    public String transferMoney(TransferRequest request) {

        Account sender = repository.findById(request.getFromId()).orElseThrow();

        Account receiver = repository.findById(request.getToId()).orElseThrow();

        if(sender.getBalance() < request.getAmount()) {
            return "Insufficient Balance";
        }

        sender.setBalance(sender.getBalance() - request.getAmount());

        receiver.setBalance(receiver.getBalance() + request.getAmount());

        repository.save(sender);

        repository.save(receiver);

        return "Transfer Successful";
    }
}