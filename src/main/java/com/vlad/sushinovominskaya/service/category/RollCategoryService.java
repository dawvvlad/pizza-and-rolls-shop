package com.vlad.sushinovominskaya.service.category;

import com.vlad.sushinovominskaya.dto.RollCategoryDTO;
import com.vlad.sushinovominskaya.entity.RollCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RollCategoryService {
    void createCategory(String name, List<RollCategoryDTO> categories);
    void updateCategory(RollCategoryDTO categoryDTO);
    List<RollCategoryDTO> getAllCategories();
}
