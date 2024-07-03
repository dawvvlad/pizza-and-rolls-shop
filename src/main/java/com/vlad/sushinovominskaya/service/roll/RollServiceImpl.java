package com.vlad.sushinovominskaya.service.roll;

import com.vlad.sushinovominskaya.dto.RollDTO;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.repo.roll.RollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RollServiceImpl implements RollService {

    private final RollRepo rollRepo;

    @Autowired
    public RollServiceImpl(RollRepo rollRepo) {
        this.rollRepo = rollRepo;
    }

    @Override
    public void save(RollDTO rollDTO) {
        Roll roll = rollRepo.find(rollDTO.getId());
        if (roll != null) {
            rollRepo.save(roll);
        }
    }

    @Override
    public void update(Long id, ) {
        Roll roll = rollRepo.find(id);

    }

    @Override
    public void delete(Long id) {
        Roll roll = rollRepo.find(id);
        rollRepo.delete(roll);
    }

    @Override
    public RollDTO findById(Long id) {
        Roll roll = rollRepo.find(id);
        if(roll == null) {
            return null;
        } else return new RollDTO(roll);
    }

    @Override
    public RollDTO findByName(String name) {
        Roll roll = rollRepo.find(name);
        if(roll == null) {
            return null;
        } else return new RollDTO(roll);
    }

    @Override
    public List<RollDTO> findAll() {
        List<Roll> rolls = rollRepo.findAll();
        List<RollDTO> rollDTOs = new ArrayList<>();
        for (Roll roll : rolls) {
            rollDTOs.add(new RollDTO(roll));
        }
        return rollDTOs.isEmpty() ? Collections.emptyList() : rollDTOs;
    }
}
