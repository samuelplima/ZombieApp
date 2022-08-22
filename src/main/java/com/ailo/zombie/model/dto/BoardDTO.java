package com.ailo.zombie.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardDTO {

    private int gridPositionX;
    private int gridPositionY;

}
