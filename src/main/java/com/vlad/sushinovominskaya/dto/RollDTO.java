package com.vlad.sushinovominskaya.dto;

import com.vlad.sushinovominskaya.entity.Roll;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RollDTO {
    private Long id;
    private String name;
    private String composition;
    private Long price;
    private String image;

    public RollDTO() {}
    public RollDTO(Long id, String name, String composition, Long price, String image) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.price = price;
        this.image = image;
    }

    public RollDTO(Roll roll) {
        this.id = roll.getId();
        this.name = roll.getName();
        this.composition = roll.getComposition();
        this.price = roll.getPrice();
        this.image = roll.getImagePath();
    }
}
