package com.codecool.ants.colony;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.randomHelper;

import static com.codecool.ants.geometry.Direction.*;

public class Drone extends Ant {

    public Drone(Position antPosition) {
        super(antPosition);
    }

    public void act(int colonySize){
    }

    private void moveAnt(Position currentPosition){
    }

    public String toString(){
        return "D ";
    }
}
