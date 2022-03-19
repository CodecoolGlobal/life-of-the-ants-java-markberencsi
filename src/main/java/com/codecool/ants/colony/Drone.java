package com.codecool.ants.colony;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.randomHelper;

import static com.codecool.ants.geometry.Direction.*;

public class Drone extends Ant {

    private int matingTimeCounter = 10;
    private boolean finishedMating = false;

    public Drone(Position antPosition) {
        super(antPosition);
    }

    public void act(int colonySize){
        if(!(getAntPosition().getX() == colonySize/2 && getAntPosition().getY() == colonySize/2)){
            moveAnt(colonySize);
        }
    }

    private void moveAnt(int colonySize){

        int currentX = getAntPosition().getX();
        int currentY = getAntPosition().getY();

        if(currentX != colonySize/2){
            if(currentX < colonySize/2){
                setAntPosition(currentX+1, currentY);
            }else{
                setAntPosition(currentX-1, currentY);
            }
        }else{
            if(currentY < colonySize/2){
                setAntPosition(currentX, currentY+1);
            }else{
                setAntPosition(currentX, currentY-1);
            }
        }

    }

    public void tryToMate(boolean isTheQueenReady, int colonySize){
        if(isTheQueenReady){
            if(matingTimeCounter == 10){
                System.out.println("Drone: HALLELUJAH!");
                mate(colonySize);
            }
            mate(colonySize);
        }else{
            System.out.println("Drone: :(");
            kickDrone(colonySize);
        }
    }

    public void mate(int colonySize){
        matingTimeCounter--;
        if(matingTimeCounter == 0){
            finishedMating = true;
            kickDrone(colonySize);
        }
    }

    public boolean hasFinishedMating(){
        return finishedMating;
    }

    public void resetMatingTimer(){
        matingTimeCounter = 10;
        finishedMating = false;
    }

    public void kickDrone(int colonySize){
        Direction[] directions = {NORTH, SOUTH, WEST, EAST};
        Direction directionToKickTowards = randomHelper.chooseOne(directions);
        int yAxisDiff = colonySize/2*directionToKickTowards.getYAxisDiff();
        int xAxisDiff = colonySize/2*directionToKickTowards.getXAxisDiff();
        setAntPosition(colonySize/2 + xAxisDiff, colonySize/2 + yAxisDiff);
    }

    public String toString(){
        return "D ";
    }
}
