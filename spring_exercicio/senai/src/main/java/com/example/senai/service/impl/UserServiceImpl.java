package com.example.senai.service.impl;

import com.example.senai.entity.User;
import com.example.senai.repository.UserRepository;
import com.example.senai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Pageable page, Specification<User> spec) {
        return null;
    }

    @Override
    public List<User> saveUser(List<User> users) {
        return List.of();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }
}
