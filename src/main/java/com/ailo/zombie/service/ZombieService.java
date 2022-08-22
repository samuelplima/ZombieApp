package com.ailo.zombie.service;

import com.ailo.zombie.model.entities.Board;
import com.ailo.zombie.model.entities.Creature;
import com.ailo.zombie.model.entities.Zombie;

public interface ZombieService {

    String zombieChasingAndCapture();

    void zombieMovementControl(String positionCoordinates, Zombie zombie, Board board);

    void captureCreature(final Zombie zombie, final Creature creature);

    String getCreaturePositionAndGenerateRoute(final Creature creature, final Zombie zombie, final Board board);

}
