package com.example.xesqye.service.Impl;

import com.example.xesqye.entity.parts.Parts;
import com.example.xesqye.repository.PartsRepository;
import com.example.xesqye.service.PartsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartsServiceImpl implements PartsService {

    @Autowired
    private PartsRepository partsRepository;

    @Override
    public List<Parts> getAllParts() {
        return this.partsRepository.findAll();
    }

    @Override
    public List<Parts> saveParts(List<Parts> parts) {
        return this.partsRepository.saveAll(parts);
    }

    @Override
    public Parts updateParts(Parts parts) {
        Optional<Parts> oldParts = this.partsRepository.findById(parts.getId());

        if(oldParts.isPresent()){
            BeanUtils.copyProperties(parts, oldParts.get(), "created_date");
            return this.partsRepository.save(oldParts.get());
        }

        return null;
    }

    @Override
    public void deleteParts(UUID id) {
        Optional<Parts> part = this.partsRepository.findById(id);

        if(part.isPresent()){
            this.partsRepository.delete(part.get());
        }

    }
}
