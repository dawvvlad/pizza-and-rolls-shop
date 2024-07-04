package com.vlad.sushinovominskaya.service.roll;

import com.vlad.sushinovominskaya.dto.RollDTO;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollCategory;
import com.vlad.sushinovominskaya.repo.category.RollCategoryRepo;
import com.vlad.sushinovominskaya.repo.roll.RollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RollServiceImpl implements RollService {

    private final RollRepo rollRepo;
    private final RollCategoryRepo rollCategoryRepo;

    @Autowired
    public RollServiceImpl(RollRepo rollRepo, RollCategoryRepo rollCategoryRepo) {
        this.rollRepo = rollRepo;
        this.rollCategoryRepo = rollCategoryRepo;
    }

    @Override
    public void createRoll(RollDTO rollDTO) {
        RollCategory category = rollCategoryRepo.findByName(rollDTO.getCategory());
        Roll roll = new Roll(category, rollDTO.getName(), rollDTO.getComposition(), rollDTO.getPrice(), rollDTO.getImage());
        category.addRoll(roll);

        rollRepo.save(roll);
    }

    @Override
    public void update(Long id, RollDTO rollDTO) {
        RollCategory category = rollCategoryRepo.findByName(rollDTO.getCategory());
        Roll roll = rollRepo.find(id);
        roll.setCategory(category);
        roll.setName(rollDTO.getName());
        roll.setComposition(rollDTO.getComposition());
        roll.setPrice(rollDTO.getPrice());
        roll.setImagePath(rollDTO.getImage());

        rollRepo.update(roll);
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

    @Override
    public List<RollDTO> findAllByCategory(String categoryName) {
        List<Roll> rolls = rollRepo.findByCategory(categoryName);
        List<RollDTO> rollDTOs = new ArrayList<>();
        for (Roll roll : rolls) {
            rollDTOs.add(new RollDTO(roll));
        }
        return rollDTOs.isEmpty() ? Collections.emptyList() : rollDTOs;
    }
}
