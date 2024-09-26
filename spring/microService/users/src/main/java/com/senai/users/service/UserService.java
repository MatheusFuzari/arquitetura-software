package com.senai.users.service;

import com.senai.users.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface UserService {
    Page<User> getAllUsers(Specification<User> spec, Pageable page);

    List<User> createUsers(List<User> user);

    User updateUser(User user);

    void deleteUser(UUID id);
}

