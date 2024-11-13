package com.senai.users.controller;

import com.senai.users.dto.UserDTO;
import com.senai.users.entity.User;
import com.senai.users.exceptions.UserNotFoundException;
import com.senai.users.service.impl.UserServiceImpl;
import com.senai.users.specifications.UserSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) throws UserNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getSingleUser(id));
    }

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getAllUsers(UserSpecification.UserSpec spec, Pageable page){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers(spec, page));
    }

    @GetMapping("/user-ids")
    public ResponseEntity<List<User>> getUsersById(@RequestParam List<UUID> ids) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUsersById(ids));
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> createUsers(@RequestBody @Valid List<UserDTO> users){
        List<User> userList = users.stream().map(
                dto -> {
                    User convertedUser = new User();
                    BeanUtils.copyProperties(dto, convertedUser);
                    return  convertedUser;
                }
        ).toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUsers(userList));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody @Valid UserDTO user){
        User convertedUser = new User();
        BeanUtils.copyProperties(user, convertedUser);
        convertedUser.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.updateUser(convertedUser));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable UUID id) throws UserNotFoundException{
        this.userService.deleteUser(id);
    }
}
