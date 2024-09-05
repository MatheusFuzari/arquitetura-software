package com.example.xesqye.repository;

import com.example.xesqye.entity.robots.Robots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RobotRepository extends JpaRepository<Robots, UUID> {
}
