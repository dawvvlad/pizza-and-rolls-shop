package com.vlad.sushinovominskaya.repo.category;

import com.vlad.sushinovominskaya.entity.RollCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RollCategoryRepo {
    void save(RollCategory rollCategory);
    void update(RollCategory rollCategory);
    RollCategory findById(Long id);
    RollCategory findByName(String name);
    List<RollCategory> findAll();
}
