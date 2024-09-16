package com.example.senai.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class AccountDTO implements Serializable {

    @NotNull
    private UUID metamask_id;

    @NotNull
    private UUID user_id;
}
