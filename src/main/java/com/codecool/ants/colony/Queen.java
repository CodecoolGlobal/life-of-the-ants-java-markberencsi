package com.codecool.ants.colony;

import com.codecool.ants.geometry.Position;

public class Queen {

    private final Position QUEENPOSITION;

    public Queen(Position queenPosition) {
        this.QUEENPOSITION = queenPosition;
    }

    public Position getQueenPosition(){
        return QUEENPOSITION;
    }
}
