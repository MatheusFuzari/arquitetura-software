package com.example.senai.controller;

import com.example.senai.dto.UserDTO;
import com.example.senai.entity.User;
import com.example.senai.service.impl.UserServiceImpl;
import com.example.senai.specifications.UserSpecifications;
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
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id){
        User user = this.userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getAllUsers(Pageable page, UserSpecifications.UserSpec userSpec){
        Page<User> users = this.userService.getAllUsers(page, userSpec);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> postUser(@RequestBody @Valid List<UserDTO> user){
        List<User> userList = user.stream().map(dto -> {
            User convertedUser = new User();
            BeanUtils.copyProperties(user, convertedUser, "created_date");
            return convertedUser;
        }).toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(userList));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> putUser(@PathVariable UUID id, @RequestBody @Valid UserDTO user){
        User convertedUser = new User();
        BeanUtils.copyProperties(user, convertedUser, "created_date");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.updateUser(id, convertedUser));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id) {
        this.userService.deleteUser(id);
    }
}
