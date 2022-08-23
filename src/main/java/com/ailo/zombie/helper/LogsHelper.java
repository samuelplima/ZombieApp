package com.ailo.zombie.helper;

import com.ailo.zombie.model.entities.Creature;
import com.ailo.zombie.model.entities.Zombie;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogsHelper {

    public static void creatureCapturedLog(final Creature creature){
        log.info("Zombie Captured Creature position X:" + creature.getPositionX() + ", Y: " + creature.getPositionY());
    }

    public static void zombieChasingCreatures(final Zombie zombie){
        log.info("Zombie in position:" + zombie.getPositionX() + ", Y: " + zombie.getPositionY());
    }

}
