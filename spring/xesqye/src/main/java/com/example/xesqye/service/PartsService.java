package com.example.xesqye.service;

import com.example.xesqye.entity.parts.Parts;

import java.util.List;
import java.util.UUID;

public interface PartsService {

    List<Parts> getAllParts();

    List<Parts> saveParts(List<Parts> parts);

    Parts updateParts(Parts parts);

    void deleteParts(UUID parts);
}
