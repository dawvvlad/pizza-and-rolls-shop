package com.vlad.sushinovominskaya.repo.set;

import com.vlad.sushinovominskaya.entity.RollSet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RollSetRepoImpl implements RollSetRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public RollSet save(RollSet rollSet) {
        if (rollSet.getId() == null) {
            entityManager.persist(rollSet);
            return rollSet;
        } else return entityManager.merge(rollSet);
    }

    @Transactional
    @Override
    public void delete(RollSet rollSet) {
        entityManager.remove(rollSet);
    }

    @Transactional
    @Override
    public RollSet find(Long id) {
        return entityManager.find(RollSet.class, id);
    }

    @Transactional
    @Override
    public RollSet find(String name) {
        try {
            return entityManager.createQuery("from RollSet rs where rs.name = :name", RollSet.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    @Override
    public List<RollSet> findAll() {
        return entityManager
                .createQuery("from RollSet", RollSet.class)
                .getResultList();
    }
}
