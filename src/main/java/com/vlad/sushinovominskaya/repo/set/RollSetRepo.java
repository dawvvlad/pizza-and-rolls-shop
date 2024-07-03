package com.vlad.sushinovominskaya.repo.set;

import com.vlad.sushinovominskaya.entity.RollSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RollSetRepo {
    RollSet save(RollSet rollSet);
    void update(RollSet rollSet);
    void delete(RollSet rollSet);
    RollSet find(Long id);
    RollSet find(String name);
    List<RollSet> findAll();
}
