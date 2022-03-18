package com.codecool.ants.colony;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.randomHelper;

import static com.codecool.ants.geometry.Direction.*;
import static com.codecool.ants.geometry.Direction.WEST;

public class Worker extends Ant {

    public Worker(Position antPosition) {
        super(antPosition);
    }

    public void act(int colonySize){
        moveAnt(colonySize);
    }

    private void moveAnt(int colonySize){
        Position currentPosition = getAntPosition();
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();

        Direction[] directions = {NORTH, SOUTH, EAST, WEST};
        Direction moveDirection = randomHelper.chooseOne(directions);
        setAntPosition
                (currentX+moveDirection.getXAxisDiff(),
                        currentY+moveDirection.getYAxisDiff());
        while(!getAntPosition().isValidCoordinate(colonySize)){
            moveDirection = randomHelper.chooseOne(directions);
            setAntPosition
                    (currentX+moveDirection.getXAxisDiff(),
                            currentY+moveDirection.getYAxisDiff());
        }
    }

    public String toString(){
        return "W ";
    }
}
