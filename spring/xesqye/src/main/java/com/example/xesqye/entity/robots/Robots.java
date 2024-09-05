package com.example.xesqye.entity.robots;


import com.example.xesqye.entity.parts.Parts;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
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

    public BigDecimal getTotalCost(){
        return new BigDecimal(0)
                .add(torso.getCost())
                .add(base.getCost())
                .add(leftArm.getCost())
                .add(rightArm.getCost())
                .add(head.getCost());
    }


}
