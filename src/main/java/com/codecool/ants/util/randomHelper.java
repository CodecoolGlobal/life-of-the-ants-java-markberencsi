package com.codecool.ants.util;

import com.codecool.ants.geometry.Direction;

import java.util.Random;

public class randomHelper {

    private static final Random RANDOM = new Random();

    public static int nextInt(int upper) {
        return RANDOM.nextInt(upper);
    }

    public static int nextInt(int lower, int upper) {
        return lower + nextInt(upper - lower);
    }

    public static Direction chooseOne(Direction[] possibilities) {
        if (possibilities == null || possibilities.length < 1) {
            final String msg =
                    "Possibilities should be a non-empty array of directions.";
            throw new IllegalArgumentException(msg);
        }

        return possibilities[nextInt(possibilities.length)];
    }
}
