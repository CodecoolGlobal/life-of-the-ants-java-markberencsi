package com.codecool.ants.colony;

import com.codecool.ants.geometry.Position;

public abstract class Ant {

    private Position antPosition;

    public Ant(Position antPosition) {
        this.antPosition = antPosition;
    }

    abstract public void act(int colonySize);

    public Position getAntPosition(){
        return antPosition;
    }

    public void setAntPosition(int xCoordinate, int yCoordinate){
        antPosition.setX(xCoordinate);
        antPosition.setY(yCoordinate);
    }

    abstract public String toString();

}
