package com.example.senai.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String cpf;

}
