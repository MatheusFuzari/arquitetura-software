package com.example.xesqye.service;

import com.example.xesqye.dto.RobotsFullDto;
import com.example.xesqye.entity.parts.Parts;
import com.example.xesqye.entity.robots.Robots;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface RobotsService {

    Page<RobotsFullDto> getFullRobots(Specification<Robots> spec, Pageable page);

    Page<Robots> getAllRobots(Specification<Robots> spec, Pageable page);

    List<Robots> saveRobots(List<Robots> robots);

    Robots updateRobots(Robots robots);

    void deleteRobots(UUID id);

}
