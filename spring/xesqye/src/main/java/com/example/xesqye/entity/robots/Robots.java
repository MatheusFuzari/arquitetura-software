package com.example.xesqye.entity.robots;


import com.example.xesqye.entity.parts.Parts;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Robots implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts head;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts base;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts leftArm;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts rightArm;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts torso;

    private UUID userId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", shape = JsonFormat.Shape.STRING)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public BigDecimal getTotalCost(){
        return new BigDecimal(0)
                .add(com.example.xesqye.utils.Data.nullSafe(torso.getCost()))
                .add(com.example.xesqye.utils.Data.nullSafe(base.getCost()))
                .add(com.example.xesqye.utils.Data.nullSafe(leftArm.getCost()))
                .add(com.example.xesqye.utils.Data.nullSafe(rightArm.getCost()))
                .add(com.example.xesqye.utils.Data.nullSafe(head.getCost()));
    }

}
