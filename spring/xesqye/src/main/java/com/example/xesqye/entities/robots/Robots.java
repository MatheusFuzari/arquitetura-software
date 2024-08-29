package com.example.xesqye.entities.robots;


import com.example.xesqye.entities.parts.Parts;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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

    private Parts torso;

    private Parts leftArm;

    private Parts rightArm;

    private Parts base;

}
