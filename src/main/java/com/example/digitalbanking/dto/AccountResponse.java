package com.example.digitalbanking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountResponse {

    private Long id;

    private String holderName;

    private Double balance;
}