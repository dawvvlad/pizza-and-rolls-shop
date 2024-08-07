package com.vlad.sushinovominskaya.service.set;

import com.vlad.sushinovominskaya.dto.RollSetDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RollSetService {
    RollSetDTO findById(Long id);
    RollSetDTO findByName(String name);
    List<RollSetDTO> findAll();
    void createRollSet(RollSetDTO rollSetDTO);
    void delete(Long id);
    void update(Long id, RollSetDTO rollSetDTO);

}
