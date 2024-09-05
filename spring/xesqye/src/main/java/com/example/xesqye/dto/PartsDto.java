package com.example.xesqye.dto;

import com.example.xesqye.entity.parts.PartType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PartsDto implements Serializable {
    @NotBlank
    private String description;
    @NotBlank
    private String title;
    @NotBlank
    private String src;
    @NotNull
    private PartType type;
    @NotNull
    private BigDecimal cost;
}
