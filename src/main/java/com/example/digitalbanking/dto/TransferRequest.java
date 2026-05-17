package com.example.digitalbanking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {

    private Long fromId;

    private Long toId;

    private Double amount;
}