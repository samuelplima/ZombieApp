package com.ailo.zombie.helper;

import com.ailo.zombie.model.dto.CreatureDTO;
import com.ailo.zombie.model.entities.Creature;

public class CreatureHelper {

    public static Creature creatureBuilder(final CreatureDTO creatureDTO){
        return Creature.builder()
                .positionX(creatureDTO.getPositionX())
                .positionY(creatureDTO.getPositionY())
                .quantity(creatureDTO.getQuantity())
                .build();
    }

    public static Creature creatureBuilderUpdate(final Creature creature, final CreatureDTO creatureDTO){
        return Creature.builder()
                .id(creature.getId())
                .positionX(creatureDTO.getPositionX())
                .positionY(creatureDTO.getPositionY())
                .quantity(creatureDTO.getQuantity())
                .build();
    }

    public static CreatureDTO creatureDTOBuilder(final Creature creature){
        return CreatureDTO.builder()
                .positionX(creature.getPositionX())
                .positionY(creature.getPositionY())
                .quantity(creature.getQuantity())
                .build();
    }

}
