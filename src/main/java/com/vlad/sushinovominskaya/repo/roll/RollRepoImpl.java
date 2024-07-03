package com.vlad.sushinovominskaya.repo.roll;

import com.vlad.sushinovominskaya.entity.Roll;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RollRepoImpl implements RollRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Roll save(Roll roll) {
        entityManager.persist(roll);
        return roll;
    }

    @Transactional
    @Override
    public void update(Roll roll) {
        entityManager.merge(roll);
    }

    @Transactional
    @Override
    public void delete(Roll roll) {
        entityManager.remove(roll);
    }

    @Transactional
    @Override
    public List<Roll> findAll() {
        return entityManager
                .createQuery("from Roll", Roll.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Roll find(Long id) {
        return entityManager.find(Roll.class, id);
    }

    @Transactional
    @Override
    public Roll find(String name) {
        try {
            return entityManager
                    .createQuery("from Roll r where r.name = :name", Roll.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
