package com.vlad.sushinovominskaya.repo.pizza;

import com.vlad.sushinovominskaya.entity.Pizza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PizzaRepoImpl implements PizzaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Pizza pizza) {
        entityManager.persist(pizza);
    }

    @Transactional
    @Override
    public void update(Pizza pizza) {
        entityManager.merge(pizza);
    }

    @Transactional
    @Override
    public void delete(Pizza pizza) {
        entityManager.remove(pizza);
    }

    @Transactional
    @Override
    public List<Pizza> findAll() {
        return entityManager
                .createQuery("from Pizza", Pizza.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Pizza find(Long id) {
        return entityManager.find(Pizza.class, id);
    }

    @Transactional
    @Override
    public Pizza find(String name) {
        try {
            return entityManager
                    .createQuery("select p from Pizza p where p.name=:name", Pizza.class)
                    .setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
