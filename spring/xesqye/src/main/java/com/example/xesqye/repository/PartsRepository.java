package com.example.xesqye.repository;

import com.example.xesqye.entity.parts.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartsRepository extends JpaRepository<Parts, UUID> {
}
