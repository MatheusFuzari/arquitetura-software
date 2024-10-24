package com.example.xesqye.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


public class UpdateRobotsDTO extends RobotsDTO implements Serializable {
    private UUID id;
}
