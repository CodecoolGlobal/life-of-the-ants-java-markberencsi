package com.codecool.ants.colony;

import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.randomHelper;

public class Queen {

    private final Position QUEENPOSITION;
    private int matingTimeCounter;

    public Queen(Position queenPosition) {
        matingTimeCounter = randomHelper.nextInt(50,100);
        this.QUEENPOSITION = queenPosition;
    }

    public Position getQueenPosition(){
        return QUEENPOSITION;
    }

    public void resetMatingTimer(){
        matingTimeCounter = randomHelper.nextInt(50,100);
    }

    public void decreaseMatingTimer(){
        if(matingTimeCounter > 0){
            matingTimeCounter--;
        }

    }

    public boolean isSheReadyToMate(){
        return matingTimeCounter == 0;
    }

}
