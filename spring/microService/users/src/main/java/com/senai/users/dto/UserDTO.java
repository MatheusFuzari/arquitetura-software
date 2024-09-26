package com.senai.users.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserDTO implements Serializable {
    private String name;
    private String cpf;
    private String phone;
    private LocalDate birthdate;
}
