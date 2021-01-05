package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class DungeonMaster {
    //<String> room = new ArrayList<>();

    public DungeonMaster() {
        //Startmeny och val att antigen starta ett nytt spel eller avsluta
        System.out.println("Welcome to Dragon Treasure. Choose one of the following options: \n" +
                "Start new game (1) \n" +
                "Exit (2)");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == 1) {
            System.out.println("Enter name: ");
            String name = scanner.next();
            Weapon stick = new Weapon("Stick", "Wooden stick, seems to be in poor condition", 1);
            Player myHero = new Player(name, 10, stick.getDamage(), stick.getName());
            System.out.printf("The adventure begins %s...", name, "%n");
            // Dungeon dungeon = new Dungeon();  // spel startar ????
            Dungeon.playGame(myHero);

        } else if (answer == 2) {
            System.out.println("Goodbye player!");
            System.exit(0);
            // avsluta systemet
        } else {
            throw new IllegalArgumentException("Incorrect Input, try again"); // funkar ej som vi vill

        }
    }
}

            /*Room startingRoom = new Room("StartingRoom");
            if (startingRoom.choice() == 1) {
                Room riddleRoom = new Room("riddleRoom");
                myHero.setDamage(1);
                scanner = new Scanner(System.in);
                String riddle = scanner.nextLine();
                if (riddleRoom.riddle(riddle) == true) {
                    Room correctAnswerRoom = new Room("correctAnswerRoom");

                } else {
                    Room monsterRoom2 = new Room("monsterRoom2");
                }
            }*/



