package com.vlad.sushinovominskaya.service.set;

import com.vlad.sushinovominskaya.dto.RollDTO;
import com.vlad.sushinovominskaya.dto.RollSetDTO;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollSet;
import com.vlad.sushinovominskaya.repo.roll.RollRepo;
import com.vlad.sushinovominskaya.repo.set.RollSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RollSetServiceImpl implements RollSetService {

    private final RollSetRepo rollSetRepo;
    private final RollRepo rollRepo;

    @Autowired
    public RollSetServiceImpl(RollSetRepo rollSetRepo, RollRepo rollRepo) {
        this.rollSetRepo = rollSetRepo;
        this.rollRepo = rollRepo;
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
    public void createRollSet(RollSetDTO rollSetDTO) {
        RollSet rollSet = new RollSet();
        List<Roll> list = new ArrayList<>();
        for(RollDTO roll : rollSetDTO.getRolls()) {
            list.add(rollRepo.find(roll.getName()));
        }
        if (list.isEmpty()) {
            rollSet.setRolls(Collections.emptyList());
        } else {
            rollSet.setRolls(list);
        }
        rollSetRepo.save(rollSet);
    }

    @Override
    public void delete(Long id) {
        RollSet rollSet = rollSetRepo.find(id);
        rollSetRepo.delete(rollSet);
    }
}
