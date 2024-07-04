package com.vlad.sushinovominskaya.service.category;

import com.vlad.sushinovominskaya.dto.RollCategoryDTO;
import com.vlad.sushinovominskaya.dto.RollDTO;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollCategory;
import com.vlad.sushinovominskaya.repo.category.RollCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RollCategoryServiceImpl implements RollCategoryService {

    private final RollCategoryRepo rollCategoryRepo;

    @Autowired
    public RollCategoryServiceImpl(RollCategoryRepo rollCategoryRepo) {
        this.rollCategoryRepo = rollCategoryRepo;
    }

    @Override
    public void createCategory(String name, List<Roll> rollList) {
        RollCategory rollCategory = new RollCategory();
        rollCategory.setName(name);
        rollCategory.setRolls(rollList);
        rollCategoryRepo.save(rollCategory);
    }

    @Override
    public void updateCategory(String categoryName, List<Roll> rollList) {
        RollCategory rollCategory = rollCategoryRepo.findByName(categoryName);
        rollCategory.setName(categoryName);
        rollCategory.setRolls(rollList);
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
