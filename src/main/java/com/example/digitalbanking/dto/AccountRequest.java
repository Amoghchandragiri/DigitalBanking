package com.example.digitalbanking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {

    private String holderName;

    private Double balance;
}