package com.senai.users.service.impl;

import com.senai.users.entity.User;
import com.senai.users.repository.UserRepository;
import com.senai.users.service.UserService;
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
    public Page<User> getAllUsers(Specification<User> spec, Pageable page) {
        return this.userRepository.findAll(page);
    }

    @Override
    public List<User> createUsers(List<User> user) {
        return this.userRepository.saveAll(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = this.userRepository.findById(user.getId());

        if(optionalUser.isPresent()){
            BeanUtils.copyProperties(user, optionalUser, "created_date");
            return this.userRepository.save(optionalUser.get());
        }

        return null;
    }

    @Override
    public void deleteUser(UUID id) {
        Optional<User> part = this.userRepository.findById(id);

        if(part.isPresent()){
            this.userRepository.delete(part.get());
        }
    }
}
