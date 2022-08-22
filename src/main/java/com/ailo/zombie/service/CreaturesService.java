package com.ailo.zombie.service;

import com.ailo.zombie.model.dto.CreatureDTO;

import java.util.List;

public interface CreaturesService {

    List<CreatureDTO> getAllCreatures();

    CreatureDTO createCreature(final CreatureDTO creatureDTO);

    void updateCreatures(final int id, final CreatureDTO creatureDTO);

}
