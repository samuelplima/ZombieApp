package com.ailo.zombie.service.impl;

import com.ailo.zombie.model.entities.Board;
import com.ailo.zombie.model.entities.Creature;
import com.ailo.zombie.model.entities.Zombie;
import com.ailo.zombie.exception.NotFoundException;
import com.ailo.zombie.repository.BoardRepository;
import com.ailo.zombie.repository.CreatureRepository;
import com.ailo.zombie.repository.ZombieRepository;
import com.ailo.zombie.service.ZombieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ZombieServiceImpl implements ZombieService {

    private final ZombieRepository zombieRepository;

    private final CreatureRepository creatureRepository;

    private final BoardRepository boardRepository;

    @Override
    public String zombieChasingAndCapture() {
        final Zombie zombie = zombieRepository.findAll().stream().findFirst().orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "Zombie Not Found!"));
        final Board board = boardRepository.findAll().stream().findFirst().orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "Board Not Found!"));
        final List<Creature> creatureList = creatureRepository.findAll();
        Creature creature = null;
        String zombieMovement;

        StringBuilder msg = new StringBuilder("Zombie Chasing Creatures");

        if (!creatureList.isEmpty()) {
            creature = creatureRepository.findAll().stream().findFirst().get();
        }

        if (creatureList.isEmpty()) {
            return msg.append("Board size [][] : ")
                    .append("X : ")
                    .append(board.getGridPositionX())
                    .append(", Y :  ")
                    .append(board.getGridPositionY())
                    .append("\n\nInitial Creatures : ")
                    .append(zombie.getQuantity() - 1)
                    .append("\n\nRemaining Creatures  : 0 ")
                    .append("\n\nInitial Zombie Quantity : ")
                    .append(1)
                    .append(", Zombie initial position : ")
                    .append("x : ")
                    .append(0)
                    .append(", Y : ")
                    .append(0)
                    .append("\n\nFinal Zombie Quantity : ")
                    .append(zombie.getQuantity())
                    .append(", Zombie final position : ")
                    .append("x : ")
                    .append(zombie.getPositionX())
                    .append(", Y : ")
                    .append(zombie.getPositionY())
                    .append("\n\nZombie Movement : ")
                    .append(zombie.getMovement())
                    .append("\n\nZOMBIES WON !!!").toString();
        }

        zombieMovement = getCreaturePositionAndGenerateRoute(creature, zombie, board);
        captureCreature(zombie, creature);
        zombie.setMovement(zombie.getMovement() + zombieMovement);

        zombieRepository.save(zombie);

        return msg.toString();
    }

    @Override
    public void zombieMovementControl(String positionCoordinates, Zombie zombie, Board board) {
        if (Objects.equals(positionCoordinates, "U")) {
            zombie.setPositionY(zombie.getPositionY() + 1);
            if (zombie.getPositionY() > board.getGridPositionY()) {
                zombie.setPositionY(board.getGridPositionY());
            }
        }

        if (Objects.equals(positionCoordinates, "D")) {
            zombie.setPositionY(zombie.getPositionY() - 1);
            if (zombie.getPositionY() < 0) {
                zombie.setPositionY(0);
            }
        }

        if (Objects.equals(positionCoordinates, "R")) {
            zombie.setPositionX(zombie.getPositionX() + 1);
            if (zombie.getPositionX() > board.getGridPositionX()) {
                zombie.setPositionX(board.getGridPositionX());
            }
        }

        if (Objects.equals(positionCoordinates, "L")) {
            zombie.setPositionX(zombie.getPositionX() - 1);
            if (zombie.getPositionX() < 0) {
                zombie.setPositionX(0);
            }
        }
    }

    @Override
    public void captureCreature(final Zombie zombie, final Creature creature) {
        if (zombie.getPositionX() == creature.getPositionX() && zombie.getPositionY() == creature.getPositionY()) {
            if (creature.getQuantity() > 0) {
                zombie.setQuantity(zombie.getQuantity() + creature.getQuantity());
                creatureRepository.delete(creature);
            }
        }
    }

    @Override
    public String getCreaturePositionAndGenerateRoute(final Creature creature, final Zombie zombie, final Board board) {
        int positionX = creature.getPositionX() - zombie.getPositionX();
        int positionY = creature.getPositionY() - zombie.getPositionY();
        StringBuilder movementCoordinates = new StringBuilder();
        String positionCoordinates;


        while (positionX != 0 && positionX > 0) {
            positionCoordinates = "R";
            zombieMovementControl(positionCoordinates, zombie, board);
            movementCoordinates.append(positionCoordinates).append(", ");
            positionX--;
        }

        while (positionY != 0 && positionY > 0) {
            positionCoordinates = "U";
            zombieMovementControl(positionCoordinates, zombie, board);
            movementCoordinates.append(positionCoordinates).append(", ");
            positionY--;
        }

        while (positionX < 0) {
            positionCoordinates = "L";
            zombieMovementControl(positionCoordinates, zombie, board);
            movementCoordinates.append(positionCoordinates).append(", ");
            positionX++;
        }

        while (positionY < 0) {
            positionCoordinates = "D";
            zombieMovementControl(positionCoordinates, zombie, board);
            movementCoordinates.append(positionCoordinates).append(", ");
            positionY++;
        }

        return movementCoordinates.toString();
    }


}
