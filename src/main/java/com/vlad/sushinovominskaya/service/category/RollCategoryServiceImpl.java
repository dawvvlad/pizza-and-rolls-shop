package com.vlad.sushinovominskaya.service.category;

import com.vlad.sushinovominskaya.dto.RollCategoryDTO;
import com.vlad.sushinovominskaya.repo.category.RollCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RollCategoryServiceImpl implements RollCategoryService {

    private final RollCategoryRepo rollCategoryRepo;

    @Autowired
    public RollCategoryServiceImpl(RollCategoryRepo rollCategoryRepo) {
        this.rollCategoryRepo = rollCategoryRepo;
    }

    @Override
    public void createCategory(String name, List<RollCategoryDTO> categories) {

    }

    @Override
    public void updateCategory(RollCategoryDTO categoryDTO) {

    }

    @Override
    public List<RollCategoryDTO> getAllCategories() {
        return List.of();
    }
}
