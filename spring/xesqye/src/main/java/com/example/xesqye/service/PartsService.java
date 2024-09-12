package com.example.xesqye.service;

import com.example.xesqye.entity.parts.Parts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface PartsService {

    Page<Parts> getAllParts(Specification<Parts> spec, Pageable page);

    List<Parts> saveParts(List<Parts> parts);

    Parts updateParts(Parts parts);

    void deleteParts(UUID parts);
}
