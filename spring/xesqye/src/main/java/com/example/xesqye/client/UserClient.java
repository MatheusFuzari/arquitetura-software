package com.example.xesqye.client;

import com.example.xesqye.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FeignClient(name = "user-client", url = "${app.users-microservice.url}")
public interface UserClient {

    @GetMapping("/user/{userId}")
    UserDTO getUserById(@PathVariable UUID userId);
}
