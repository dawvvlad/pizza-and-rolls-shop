package com.vlad.sushinovominskaya.repo.order;

import com.vlad.sushinovominskaya.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepoImpl implements OrderRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Transactional
    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }

    @Transactional
    @Override
    public List<Order> findAll() {
        return entityManager
                .createQuery("from Order order", Order.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Order find(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Transactional
    @Override
    public Order findByPhoneNumber(String phoneNumber) {
        try {
            return entityManager
                    .createQuery("select r from Order r where r.customerPhone = :phoneNumber", Order.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
