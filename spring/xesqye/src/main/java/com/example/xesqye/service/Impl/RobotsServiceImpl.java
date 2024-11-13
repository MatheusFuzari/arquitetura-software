package com.example.xesqye.service.Impl;

import com.example.xesqye.client.UserService;
import com.example.xesqye.dto.RobotsFullDto;
import com.example.xesqye.dto.UserDTO;
import com.example.xesqye.entity.parts.Parts;
import com.example.xesqye.entity.robots.Robots;
import com.example.xesqye.repository.RobotsRepository;
import com.example.xesqye.service.RobotsService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class RobotsServiceImpl implements RobotsService {

    @Autowired
    private RobotsRepository robotsRepository;

    @Autowired
    private UserService userService;

    @Override
    public Page<RobotsFullDto> getFullRobots(Specification<Robots> spec, Pageable page) {
        Page<Robots> robotsFound = this.getAllRobots(spec, page);
        List<RobotsFullDto> robotsDtos = new ArrayList<>();
        List<UserDTO> userDTOS = userService.getUsersByIds(
                robotsFound.getContent().stream().map(Robots::getUserId).toList()
        );

        robotsFound.getContent().stream().forEach(
                robot -> {
                    var userFound = userDTOS.stream().filter(u -> u.getId().equals(robot.getUserId())).findFirst().orElse(null);

                    robotsDtos.add(

                    )
                }
        );
        return new PageImpl<>(robotsDtos, robotsFound.getPageable(), robotsFound.getTotalElements());
    }

    @Override
    public Page<Robots> getAllRobots(Specification<Robots> spec, Pageable page) {
        return this.robotsRepository.findAll(spec, page);
    }

    @Override
    public List<Robots> saveRobots(List<Robots> robots) {
        List<UUID> robotIds = new ArrayList<>();
        robots.stream().forEach(robot -> {
            if(userService.checkIfUserExists(robot.getUserId())){
                robotIds.add(
                        robotsRepository.saveAndFlush(robot).getId()
                );
            }
            else {
                log.error("User with id : {} does not exist!", robot.getUserId());
            }
        });

        return this.robotsRepository.findAllById(robotIds);
    }

    @Override
    public Robots updateRobots(Robots robots) {
        Optional<Robots> robotFound = this.robotsRepository.findById(robots.getId());

        if(robotFound.isPresent()){
            BeanUtils.copyProperties(robots, robotFound.get());
            return this.robotsRepository.save(robotFound.get());
        }

        return null;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteRobots(UUID id) {
        Optional<Robots> robotFound = this.robotsRepository.findById(id);

        if(robotFound.isPresent()){
            this.robotsRepository.delete(robotFound.get());
        }
    }
}
