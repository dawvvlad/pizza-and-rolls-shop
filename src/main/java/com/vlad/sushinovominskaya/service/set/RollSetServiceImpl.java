package com.vlad.sushinovominskaya.service.set;

import com.vlad.sushinovominskaya.dto.RollSetDTO;
import com.vlad.sushinovominskaya.entity.RollSet;
import com.vlad.sushinovominskaya.repo.set.RollSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RollSetServiceImpl implements RollSetService {

    private final RollSetRepo rollSetRepo;
    @Autowired
    public RollSetServiceImpl(RollSetRepo rollSetRepo) {
        this.rollSetRepo = rollSetRepo;
    }

    @Override
    public RollSetDTO findById(Long id) {
        RollSet rollSet = rollSetRepo.find(id);
        if (rollSet == null) {
            return null;
        } else return new RollSetDTO(rollSet);
    }

    @Override
    public RollSetDTO findByName(String name) {
        RollSet rollSet = rollSetRepo.find(name);
        if (rollSet == null) {
            return null;
        } else return new RollSetDTO(rollSet);
    }

    @Override
    public List<RollSetDTO> findAll() {
        List<RollSet> rollSets = rollSetRepo.findAll();
        List<RollSetDTO> rollSetDTOs = new ArrayList<>();
        for (RollSet rollSet : rollSets) {
            rollSetDTOs.add(new RollSetDTO(rollSet));
        }
        return rollSetDTOs.isEmpty() ? Collections.emptyList() : rollSetDTOs;
    }

    @Override
    public void createRoll(RollSetDTO rollSetDTO) {
        RollSet rollSet = rollSetRepo.find(rollSetDTO.getId());
        rollSetRepo.save(rollSet);
    }

    @Override
    public void delete(Long id) {
        RollSet rollSet = rollSetRepo.find(id);
        rollSetRepo.delete(rollSet);
    }
}
