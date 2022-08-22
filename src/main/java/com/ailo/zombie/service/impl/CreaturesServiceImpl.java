package com.ailo.zombie.service.impl;

import com.ailo.zombie.helper.CreatureHelper;
import com.ailo.zombie.model.dto.CreatureDTO;
import com.ailo.zombie.model.entities.Creature;
import com.ailo.zombie.exception.NotFoundException;
import com.ailo.zombie.repository.CreatureRepository;
import com.ailo.zombie.service.CreaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ailo.zombie.helper.CreatureHelper.creatureBuilder;
import static com.ailo.zombie.helper.CreatureHelper.creatureBuilderUpdate;
import static com.ailo.zombie.helper.CreatureHelper.creatureDTOBuilder;

@Service
@RequiredArgsConstructor
public class CreaturesServiceImpl implements CreaturesService {

    private final CreatureRepository creatureRepository;

    @Override
    public List<CreatureDTO> getAllCreatures() {
        final List<Creature> creatureList = creatureRepository.findAll();
        return creatureList.stream()
                .map(CreatureHelper::creatureDTOBuilder)
                .collect(Collectors.toList());
    }

    @Override
    public CreatureDTO createCreature(final CreatureDTO creatureDTO) {
        creatureRepository.save(creatureBuilder(creatureDTO));
        return creatureDTOBuilder(creatureBuilder(creatureDTO));
    }

    @Override
    public void updateCreatures(final int id, final CreatureDTO creatureDTO) {
        final Creature creature = creatureRepository.findById(id).orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "Id Not Found!"));
        creatureRepository.save(creatureBuilderUpdate(creature, creatureDTO));
    }
}
