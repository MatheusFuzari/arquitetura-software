package com.example.xesqye.repository;

import com.example.xesqye.entity.robots.Robots;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RobotsRepository extends JpaRepository<Robots, UUID>, JpaSpecificationExecutor<Robots> {

    List<Robots> findAll(Specification<Robots> spec);

    Page<Robots> findAll(Specification<Robots> spec, Pageable pageable);
}
