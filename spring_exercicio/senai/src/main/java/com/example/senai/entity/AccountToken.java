package com.example.senai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "account_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Token token_id;

    @ManyToOne
    private Account account_id;

    private BigDecimal amount;
}
