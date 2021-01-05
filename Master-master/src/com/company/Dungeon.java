package com.company;

public class Dungeon {
   /*Room startingRoom = new Room();
    Room riddleRoom1 = new Room();
    Room monsterRoom1 = new Room(); */

    public static void playGame(Player player) {
        //Intro till första grottan. Går till första rummet
        System.out.println("You are standing outside a large cave, you see a sign on the right saying: \n" +
                "DO NOT ENTER!! \n" +
                "As the daring adventurer you are, you ignore the sign and enter into the cave \n" +
                "All of a sudden, you hear a large bang and the entrance collapses behind you. \n" +
                "There is no way out now... ");

        Room.startingRoom(player);


    }

}
