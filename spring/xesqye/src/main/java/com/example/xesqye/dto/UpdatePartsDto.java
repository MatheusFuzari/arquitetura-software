package com.example.xesqye.dto;


import com.example.xesqye.entity.parts.Parts;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UpdatePartsDto extends PartsDto implements Serializable {

    @NotNull
    private UUID id;
}
