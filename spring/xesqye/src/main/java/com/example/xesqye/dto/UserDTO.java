package com.example.xesqye.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDTO implements Serializable {
    private UUID id;
    private String name;
    private LocalDate birthdate;
    private String cpf;
    private String phone;
    private LocalDateTime creationDate;
}
