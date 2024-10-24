package com.example.xesqye.controller;

import com.example.xesqye.dto.PartsDto;
import com.example.xesqye.dto.UpdatePartsDto;
import com.example.xesqye.entity.parts.Parts;
import com.example.xesqye.service.PartsService;
import com.example.xesqye.specifications.PartsSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/parts")
@CrossOrigin(origins = "*")
public class PartsController {

    @Autowired
    PartsService partsService;


    @GetMapping("/parts")
    public ResponseEntity<Page<Parts>> getAllParts(PartsSpecification.PartsSpec spec, Pageable page) {
        //select * from parts;
        Page<Parts> parts = partsService.getAllParts(spec, page);
        return ResponseEntity.ok(parts);
    }

    @PostMapping("/parts")
    public ResponseEntity<List<Parts>> addParts(@RequestBody @Valid List<PartsDto> parts) {
        List<Parts> partsList = parts.stream().map(
                dto -> {
                    Parts convertPart = new Parts();
                    BeanUtils.copyProperties(dto, convertPart);
                    return convertPart;
                }
        ).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(partsService.saveParts(partsList));
    }

    @PutMapping("/parts/{id}")
    public ResponseEntity<Parts> updatePart(@RequestBody @Valid UpdatePartsDto parts, @PathVariable UUID id) {
        Parts convertPart = new Parts();
        BeanUtils.copyProperties(parts, convertPart);
        convertPart.setId(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(partsService.updateParts(convertPart));

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/parts/{id}")
    public void deletePart(@PathVariable UUID id) {
        partsService.deleteParts(id);
    }
}
