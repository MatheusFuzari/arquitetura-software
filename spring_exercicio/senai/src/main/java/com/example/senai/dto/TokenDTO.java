package com.example.senai.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TokenDTO implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;
}
