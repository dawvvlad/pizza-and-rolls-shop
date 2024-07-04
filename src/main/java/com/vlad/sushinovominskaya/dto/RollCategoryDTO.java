package com.vlad.sushinovominskaya.dto;

import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RollCategoryDTO {
    private Long id;
    private String name;
    private List<RollDTO> rolls;

    public RollCategoryDTO() {}
    public RollCategoryDTO(Long id, String name, List<RollDTO> rolls) {
        this.id = id;
        this.name = name;
        this.rolls = rolls;
    }

    public void addRollToCategory(RollDTO roll) {
        if(this.rolls == null) {
            this.rolls = new ArrayList<>();
        }
        this.rolls.add(roll);
    }

    public RollCategoryDTO(RollCategory rollCategory) {
        this.id = rollCategory.getId();
        this.name = rollCategory.getName();
        this.rolls = new ArrayList<>();
        for (Roll roll : rollCategory.getRolls()) {
            this.rolls.add(new RollDTO(roll));
        }
    }
}
