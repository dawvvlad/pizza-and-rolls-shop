package com.vlad.sushinovominskaya.service.roll;

import com.vlad.sushinovominskaya.dto.RollDTO;
import com.vlad.sushinovominskaya.entity.Roll;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RollService {
    void save(RollDTO rollDTO);
    void delete(Long id);
    RollDTO findById(Long id);
    RollDTO findByName(String name);
    List<RollDTO> findAll();
}
