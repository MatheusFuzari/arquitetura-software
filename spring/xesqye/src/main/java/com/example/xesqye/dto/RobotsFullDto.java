package com.example.xesqye.dto;


import com.example.xesqye.entity.parts.Parts;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RobotsFullDto implements Serializable {

    private UUID id;
    private Parts head;
    private Parts base;
    private Parts leftArm;
    private Parts rightArm;
    private Parts torso;
    private UserDTO user;
    private LocalDateTime createdDate;
    private BigDecimal totalCost;

}
