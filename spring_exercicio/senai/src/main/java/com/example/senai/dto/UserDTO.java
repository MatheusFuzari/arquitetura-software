package com.example.senai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDTO implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private LocalDate birthday;

    @Null
    private LocalDateTime created_date;

    @NotNull
    private String cpf;

}
