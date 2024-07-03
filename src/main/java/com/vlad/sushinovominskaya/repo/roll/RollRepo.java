package com.vlad.sushinovominskaya.repo.roll;

import com.vlad.sushinovominskaya.entity.Roll;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RollRepo {
    Roll save(Roll roll);
    void update(Roll roll);
    void delete(Roll roll);
    List<Roll> findAll();
    Roll find(Long id);
    Roll find(String name);
}
