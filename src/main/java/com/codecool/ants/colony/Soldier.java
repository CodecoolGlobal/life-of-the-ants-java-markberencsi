package com.codecool.ants.colony;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.randomHelper;

import static com.codecool.ants.geometry.Direction.*;
import static com.codecool.ants.geometry.Direction.WEST;

public class Soldier extends Ant {

    private int patrolCycle = 0;

    public Soldier(Position antPosition) {
        super(antPosition);
    }

    public void act(int colonySize){
        Direction[] directions = {NORTH, NORTH, WEST, WEST, SOUTH, SOUTH, EAST, EAST};
        moveAnt(colonySize, directions);
    }

    private void moveAnt(int colonySize, Direction[] directions){
        if(patrolCycle > 7){
            patrolCycle = 0;
        }
        Position currentPosition = getAntPosition();
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();

        Direction moveDirection = directions[patrolCycle];
        setAntPosition
                (currentX+moveDirection.getXAxisDiff(),
                        currentY+moveDirection.getYAxisDiff());
        patrolCycle++;
    }

    public String toString(){
        return "S ";
    }
}
