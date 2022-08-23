package com.ailo.zombie.service.impl;

import com.ailo.zombie.model.entities.Creature;
import com.ailo.zombie.repository.CreatureRepository;
import com.ailo.zombie.service.AppRunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppRunServiceImpl implements AppRunService {

    private final CreatureRepository creatureRepository;

    private final ZombieServiceImpl zombieService;

    @Override
    public String invoke() {
        final List<Creature> creatureList = creatureRepository.findAll();
        String msg = null;

        if(creatureList.isEmpty()){
            return msg = "There are no more creatures! Please add more to chase again!";
        }

        for (int i = 0; i < creatureList.size() + 1; i++) {
            msg = zombieService.zombieChasingAndCapture();
        }


        return msg;
    }
}
