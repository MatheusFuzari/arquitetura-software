package com.example.xesqye.entity.parts;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
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
public class Parts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 250, nullable = false)
    private String description;

    @Column(length = 120, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String src;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PartType type;

    @Column(nullable = false)
    private BigDecimal cost;


}
