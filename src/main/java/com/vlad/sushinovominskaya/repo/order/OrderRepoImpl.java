package com.vlad.sushinovominskaya.repo.order;

import com.vlad.sushinovominskaya.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepoImpl implements OrderRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }

    @Override
    public List<Order> findAll() {
        return entityManager
                .createQuery("from Order order", Order.class)
                .getResultList();
    }

    @Override
    public Order find(Long id) {
        return entityManager.find(Order.class, id);
    }

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
