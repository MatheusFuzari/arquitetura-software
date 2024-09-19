package com.example.senai.service;


import com.example.senai.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User getUser(UUID id);

    Page<User> getAllUsers(Pageable page, Specification<User> spec);

    List<User> saveUser(List<User> users);

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);
}
