package com.example.xesqye.client;

import com.example.xesqye.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserClient userClient;

    // Search for user in microservice
    public UserDTO getUserIfExists(UUID id){
        try{
            return userClient.getUserById(id);
        } catch (Exception e){
            log.error("User not found or ");
            return null;
        }
    }

    public boolean checkIfUserExists(UUID id){
        return Objects.nonNull(getUserIfExists(id));
    }
}
