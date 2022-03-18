package com.codecool.ants.geometry;

    public enum Direction {
        NORTH(-1, 0),
        EAST(0, +1),
        SOUTH(+1, 0),
        WEST(0, -1);


        private final int xDiff;
        private final int yDiff;

        Direction(int xDiff, int yDiff) {
            this.xDiff = xDiff;
            this.yDiff = yDiff;
        }

        public int getXAxisDiff(){
            return xDiff;
        }

        public int getYAxisDiff(){
            return yDiff;
        }

    }




