package com.codecool.ants;

import com.codecool.ants.colony.Colony;

import java.util.Objects;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
        Colony c = new Colony(11);
        c.generateAnts(3,3,3);
        Scanner s = new Scanner(System.in);
        while(true){
            c.display();
            String input = s.nextLine();
            if(Objects.equals(input, "q") || Objects.equals(input, "Q")){
                break;
            }
            c.update();
        }

    }


}
