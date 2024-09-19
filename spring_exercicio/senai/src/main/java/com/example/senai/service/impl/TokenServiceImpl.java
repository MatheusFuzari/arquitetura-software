package com.example.senai.service.impl;

import com.example.senai.entity.Token;
import com.example.senai.repository.TokenRepository;
import com.example.senai.service.TokenService;
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
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token getToken(UUID id) {
        Optional<Token> optionalToken = this.tokenRepository.findById(id);

        if(optionalToken.isPresent()){
            return optionalToken.get();
        }

        return null;
    }

    @Override
    public Page<Token> getAllTokens(Pageable page, Specification<Token> spec) {
        return this.tokenRepository.findAll(spec, page);
    }

    @Override
    public List<Token> saveTokens(List<Token> tokens) {
        return this.tokenRepository.saveAll(tokens);
    }

    @Override
    public Token updateToken(UUID id, Token token) {
        Optional<Token> optionalToken = this.tokenRepository.findById(id);

        if(optionalToken.isPresent()){
            BeanUtils.copyProperties(token, optionalToken);
            return this.tokenRepository.save(optionalToken.get());
        }

        return null;
    }

    @Override
    public void deleteToken(UUID id) {
        Optional<Token> optionalToken = this.tokenRepository.findById(id);
        if(optionalToken.isPresent()){
            this.tokenRepository.delete(optionalToken.get());
        }
    }
}
