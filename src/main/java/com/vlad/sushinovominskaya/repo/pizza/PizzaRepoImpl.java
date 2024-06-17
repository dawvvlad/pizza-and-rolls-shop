package com.vlad.sushinovominskaya.repo.pizza;

import com.vlad.sushinovominskaya.entity.Pizza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepoImpl implements PizzaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void persist(Pizza pizza) {
        this.entityManager.persist(pizza);
    }
}
