package com.ailo.zombie.helper;

import com.ailo.zombie.model.entities.Board;
import com.ailo.zombie.model.entities.Creature;
import com.ailo.zombie.model.entities.Zombie;

public class ZombieHelper {

    public static StringBuilder printFinalMsg(final StringBuilder msg, final Zombie zombie, final Creature creature, final Board board){
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
                .append("\n\nZOMBIES WON !!!");
    }

}
