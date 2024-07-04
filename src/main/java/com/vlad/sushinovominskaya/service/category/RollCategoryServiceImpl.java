package com.vlad.sushinovominskaya.service.category;

import com.vlad.sushinovominskaya.dto.RollCategoryDTO;
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
public class RollCategoryServiceImpl implements RollCategoryService {

    private final RollCategoryRepo rollCategoryRepo;
    private final RollRepo rollRepo;

    @Autowired
    public RollCategoryServiceImpl(RollCategoryRepo rollCategoryRepo, RollRepo rollRepo) {
        this.rollCategoryRepo = rollCategoryRepo;
        this.rollRepo = rollRepo;
    }

    @Override
    public void createCategory(String name) {
        RollCategory rollCategory = new RollCategory(name);
        rollCategoryRepo.save(rollCategory);

        System.out.println(rollCategory);
    }

    @Override
    public void updateCategory(Long id, List<Long> rollIds, String name) {
        RollCategory rollCategory = rollCategoryRepo.findById(id);
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else rollCategory.setName(name);

        for (Long rollId : rollIds) {
            Roll roll = rollRepo.find(rollId);
            rollCategory.addRoll(roll);
        }

        rollCategoryRepo.update(rollCategory);
    }

    @Override
    public RollCategoryDTO getCategoryByName(String name) {
        return new RollCategoryDTO(rollCategoryRepo.findByName(name));
    }

    @Override
    public RollCategoryDTO getCategoryById(Long id) {
        return new RollCategoryDTO(rollCategoryRepo.findById(id));
    }

    @Override
    public List<RollCategoryDTO> getAllCategories() {
        List<RollCategory> categories = rollCategoryRepo.findAll();
        List<RollCategoryDTO> categoriesDTO = new ArrayList<>();
        for (RollCategory category : categories) {
            categoriesDTO.add(new RollCategoryDTO(category));
        }
        return categoriesDTO.isEmpty() ? Collections.emptyList() : categoriesDTO;
    }
}
