package com.example.senai.service.impl;

import com.example.senai.entity.User;
import com.example.senai.repository.UserRepository;
import com.example.senai.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(UUID id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }

        return null;
    }

    @Override
    public Page<User> getAllUsers(Pageable page, Specification<User> spec) {
        return this.userRepository.findAll(spec, page);
    }

    @Override
    public List<User> saveUser(List<User> users) {
        return this.userRepository.saveAll(users);
    }

    @Override
    public User updateUser(UUID id, User user) {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isPresent()){
            BeanUtils.copyProperties(user, optionalUser);
            return this.userRepository.save(optionalUser.get());
        }

        return null;
    }

    @Override
    public void deleteUser(UUID id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if(userOptional.isPresent()){
            this.userRepository.delete(userOptional.get());
        }
    }
}
