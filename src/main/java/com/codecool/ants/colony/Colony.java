package com.codecool.ants.colony;

import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.randomHelper;

import java.util.ArrayList;

public class Colony {

    private final int WIDTH;
    private ArrayList<Ant> ants = new ArrayList<>();
    private final Queen QUEENANT;

    public Colony(int width) {
        this.WIDTH = width;
        QUEENANT = new Queen(new Position(WIDTH/2, WIDTH/2));
    }

    public void generateAnts(int noOfDrones, int noOfWorkers, int noOfSoldiers){
        for(int i = 0; i < noOfDrones; i++){
            ants.add(new Drone(new Position
                    (randomHelper.nextInt(WIDTH), randomHelper.nextInt(WIDTH))));
        }
        for(int i = 0; i < noOfWorkers; i++){
            ants.add(new Worker(new Position
                    (randomHelper.nextInt(WIDTH), randomHelper.nextInt(WIDTH))));
        }
        for(int i = 0; i < noOfSoldiers; i++){
            ants.add(new Soldier(new Position
                    (randomHelper.nextInt(2,WIDTH-2),
                            randomHelper.nextInt(2, WIDTH-2))));
        }
    }

    public void update(){
        QUEENANT.decreaseMatingTimer();
        for(Ant ant: ants){
            ant.act(WIDTH);
            if(ant instanceof Drone){
                if(ant.getAntPosition().getX() == QUEENANT.getQueenPosition().getX()
                && ant.getAntPosition().getY() == QUEENANT.getQueenPosition().getY()){
                    ((Drone) ant).tryToMate(QUEENANT.isSheReadyToMate(), WIDTH);
                    if(((Drone) ant).hasFinishedMating()){
                        QUEENANT.resetMatingTimer();
                        ((Drone) ant).resetMatingTimer();
                    }
                }
            }
        }

    }

    public void display(){
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < WIDTH; j++){
                if(i == WIDTH/2 && j == WIDTH/2){
                    System.out.print("Q ");
                }else{
                    boolean isAnt = false;
                    for(Ant ant: ants){
                        int antXCoordinate = ant.getAntPosition().getX();
                        int antYCoordinate = ant.getAntPosition().getY();

                        if(antXCoordinate == i && antYCoordinate == j){
                            isAnt = true;
                            System.out.print(ant);
                            break;
                        }
                    }
                    if(!isAnt){
                        System.out.print("_ ");
                    }
                }
            }
            System.out.println();
        }
    }





}
