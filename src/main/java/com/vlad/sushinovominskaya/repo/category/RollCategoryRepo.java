package com.vlad.sushinovominskaya.repo.category;

import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RollCategoryRepo {
    void save(RollCategory rollCategory);
    void update(RollCategory rollCategory);
    List<RollCategory> findAll();
}
