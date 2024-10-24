package com.example.xesqye.dto;

import com.example.xesqye.entity.parts.Parts;
import com.example.xesqye.entity.robots.Robots;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RobotsDTO implements Serializable {
    private UUID head;

    private UUID base;

    private UUID leftArm;

    private UUID rightArm;

    private UUID torso;

    private UUID userId;

    @JsonIgnore
    public Robots mapToRobots(){
        return Robots.builder()
                .head(
                        Parts.builder()
                                .id(this.head)
                                .build()
                )
                .base(
                        Parts.builder()
                                .id(this.base)
                                .build()
                )
                .leftArm(
                        Parts.builder()
                                .id(this.leftArm)
                                .build()
                )
                .rightArm(
                        Parts.builder()
                                .id(this.rightArm)
                                .build()
                )
                .torso(
                        Parts.builder()
                                .id(this.torso)
                                .build()
                )
                .userId(this.userId)
                .build();
    }
}
