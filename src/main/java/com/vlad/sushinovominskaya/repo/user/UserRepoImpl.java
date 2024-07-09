package com.vlad.sushinovominskaya.repo.user;

import com.vlad.sushinovominskaya.config.User.MyUserDetail;
import com.vlad.sushinovominskaya.config.User.MyUserDetailService;
import com.vlad.sushinovominskaya.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    @Override
    public User findByUsername(String username) {
        try {
            return entityManager.createQuery("select u from User u where u.username=:name", User.class)
                    .setParameter("name", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User changePassword(String username, String password) {
        User user = findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        entityManager.merge(user);

        return user;
    }


}
