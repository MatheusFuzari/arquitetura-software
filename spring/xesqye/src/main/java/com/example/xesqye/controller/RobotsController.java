package com.example.xesqye.controller;

import com.example.xesqye.dto.PartsDto;
import com.example.xesqye.dto.RobotsDTO;
import com.example.xesqye.dto.UpdatePartsDto;
import com.example.xesqye.dto.UpdateRobotsDTO;
import com.example.xesqye.entity.parts.Parts;
import com.example.xesqye.entity.robots.Robots;
import com.example.xesqye.service.PartsService;
import com.example.xesqye.service.RobotsService;
import com.example.xesqye.specifications.PartsSpecification;
import com.example.xesqye.specifications.RobotsSpecification;
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
@RequestMapping("/api")
@CrossOrigin("*")
public class RobotsController {

    @Autowired
    RobotsService robotsService;


    @GetMapping("/robots")
    public ResponseEntity<Page<Robots>> getAllRobots(RobotsSpecification.RobotSpec spec, Pageable page) {
        //select * from parts;
        Page<Robots> parts = robotsService.getAllRobots(spec, page);
        return ResponseEntity.ok(parts);
    }

    @PostMapping("/robots")
    public ResponseEntity<List<Robots>> addRobots(@RequestBody @Valid List<RobotsDTO> robots) {

        List<Robots> robotsList = robots.stream().map(RobotsDTO::mapToRobots).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(robotsService.saveRobots(robotsList));
    }

    @PutMapping("/robots/{id}")
    public ResponseEntity<Robots> updateRobot(@RequestBody @Valid UpdateRobotsDTO robot, @PathVariable UUID id) {
        Robots convertRobot = robot.mapToRobots();
        convertRobot.setId(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(robotsService.updateRobots(convertRobot));

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/robots/{id}")
    public void deleteRobot(@PathVariable UUID id) {
        robotsService.deleteRobots(id);
    }
}
