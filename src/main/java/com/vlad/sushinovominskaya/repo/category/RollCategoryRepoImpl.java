package com.vlad.sushinovominskaya.repo.category;

import com.vlad.sushinovominskaya.entity.RollCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class RollCategoryRepoImpl implements RollCategoryRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(RollCategory rollCategory) {
        entityManager.persist(rollCategory);
    }

    @Transactional
    @Override
    public void update(RollCategory rollCategory) {
        entityManager.merge(rollCategory);
    }

    @Transactional
    @Override
    public List<RollCategory> findAll() {
        List<RollCategory> rollCategories = entityManager
                .createQuery("from RollCategory", RollCategory.class)
                .getResultList();

        return rollCategories.isEmpty() ? Collections.emptyList() : rollCategories;
    }
}
