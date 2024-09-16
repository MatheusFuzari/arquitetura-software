package com.example.senai.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountTokenDTO implements Serializable {

    @NotNull
    private UUID token_id;

    @NotNull
    private UUID account_id;

    @NotNull
    private BigDecimal amount;
}
