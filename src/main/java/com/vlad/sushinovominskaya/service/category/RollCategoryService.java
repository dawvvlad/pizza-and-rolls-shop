package com.vlad.sushinovominskaya.service.category;

import com.vlad.sushinovominskaya.dto.RollCategoryDTO;
import com.vlad.sushinovominskaya.dto.RollDTO;
import com.vlad.sushinovominskaya.entity.Roll;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RollCategoryService {
    void createCategory(String name);
    void updateCategory(Long id, List<Long> rollIds, String name);
    RollCategoryDTO getCategoryByName(String name);
    RollCategoryDTO getCategoryById(Long id);
    List<RollCategoryDTO> getAllCategories();
}
