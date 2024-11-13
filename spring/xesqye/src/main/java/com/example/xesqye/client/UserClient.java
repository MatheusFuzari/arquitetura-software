package com.example.xesqye.client;

import com.example.xesqye.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;


@FeignClient(name = "user-client", url = "${app.users-microservice.url}")
@Configuration
public interface UserClient {

    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable UUID userId);

    @GetMapping("/user-ids/{usersIds}")
    List<UserDTO> getUsersById(@PathVariable List<UUID> userIds);

}
