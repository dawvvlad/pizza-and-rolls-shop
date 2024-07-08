package com.vlad.sushinovominskaya.repo.user;

import com.vlad.sushinovominskaya.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo {
    User findByUsername(String username);
    User findById(Long id);
    void create(User user);
}
