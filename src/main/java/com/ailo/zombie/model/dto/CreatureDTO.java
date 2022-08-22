package com.ailo.zombie.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatureDTO {

    private int quantity;
    private int positionX;
    private int positionY;

}
