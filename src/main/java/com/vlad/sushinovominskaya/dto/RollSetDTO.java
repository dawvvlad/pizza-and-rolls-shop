package com.vlad.sushinovominskaya.dto;

import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollSet;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RollSetDTO {
    private Long id;
    private String name;
    private Long price;
    private String image;
    private List<RollDTO> rolls = new ArrayList<>();

    public RollSetDTO() {}
    public RollSetDTO(Long id, String name, Long price, String image, List<RollDTO> rolls) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.rolls = rolls;
    }

    public RollSetDTO(RollSet rollSet) {
        this.id = rollSet.getId();
        this.name = rollSet.getName();
        this.price = rollSet.getPrice();
        this.image = rollSet.getImagePath();

        for (Roll roll : rollSet.getRolls()) {
            this.rolls.add(new RollDTO(roll));
        }
    }

    public void addRollToSet(Roll roll) {
        this.rolls.add(new RollDTO(roll));
    }

    public void addRollToSet(RollDTO rollDTO) {
        this.rolls.add(rollDTO);
    }

}
