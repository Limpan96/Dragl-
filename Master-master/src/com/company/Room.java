package com.company;

import java.util.Scanner;

public class Room {


    public static void startingRoom(Player player) {
        //Första rummet som spelaren kommer till. Spelaren får ett val att gå norr eller söder
        System.out.println("There's an old man coming up to you, he says: \n" +
                "You are stuck in this cave now! \n" +
                "To get out of here, you will need to go through a couple of rooms. \n" +
                "You will meet monsters, dragons and untold dangers through the way! \n" +
                "You have to choose to go south(1) or north(2) from here, choose carefully!");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == 1) {
            Room.RiddleRoom1(player);
        } else if (answer == 2) {
            Room.MonsterRoom1(player);
        } else {
            throw new IllegalArgumentException("Incorrect Input, try again");
        }

    }


    public static void RiddleRoom1(Player player) {
        System.out.println("You are now in the Riddle room. On the ground you see an axe. You pick up the weapon.");
        // player.Item
        Weapon axe = new Weapon("Axe", "Massive axe with sharp edges", 2);
        player.setDamage(axe.getDamage());
        System.out.println("You will need to answer correctly on the following riddle \n" +
                "in order to receive a gift. If not, you will face a losers challenge \n" +
                "Are you ready??? \n" +
                "Here it comes.....\n" +
                "What moves without feet?");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("clock")) {
            System.out.println("Correct Answer! \n" +
                    "Congratulations!");

            Room.CorrectAnswerRoom(player);

        } else {
            System.out.println("Wrong answer! \n" +
                    "Unfortunately you will not receive the reward. Instead you will meet your first Monster!");

            Room.MonsterRoom1(player);
        }
    }

    public static void MonsterRoom1(Player player) {
        Monster skeleton = new Monster("Skeleton", 5, 1);
        System.out.println("You chose to go north, this means you will meet your first monster. \n" +
                "Unfortunately you don't have any weapons yet, you can only use your bare hands. \n" +
                "You see a " + skeleton.getName() + " walking towards you slowly. He looks threatening and angry. \n" +
                "You decide to make your first move, you do not want to loose already.\n"
        );
        Room.doBattle(player, skeleton, skeleton.getHealthPoints(), player.getHealthPoints(),
                skeleton.getDamage(), player.getDamage());
        System.out.println("Good job, you defeated the monster! You see a spear laying on the ground.");
        Weapon spear = new Weapon("spear", "long spear with a very sharp edge. It has strange engravings on the hilt", 3);
        System.out.println("You pick up the " + spear.getName() + ". Its a " + spear.getDescription());

        System.out.println();
        System.out.println("There's a door located to the east, do you wish to pass through it?(e)");
        player.setDamage(spear.getDamage());
        Scanner scanner = new Scanner(System.in);

        String answer = scanner.next();

        if (answer.equalsIgnoreCase("e")) {
            System.out.println();
            Room.RiddleRoom2(player);
        } else {
            System.out.println("As there's no food available in this room, you'll starve.... and die.... GAME OVER");
            System.exit(0);

        }
    }

    public static void CorrectAnswerRoom(Player player) {
        System.out.println("You are now entering the next room, here you will get a reward.\n" +
                "You see a shiny sword laying on the ground, you pick it up.\n" +
                "You hear a voice saying 'This is your reward, use it wisely'\n");


        Weapon sword = new Weapon("Sword", "Long metal sword with a dragon symbol on the handle", 3);

        Room.MonsterRoom3(player);

    }


    public static void RiddleRoom2(Player player) {
        System.out.println("You are now in the Riddle room. If you will answer this riddle \n" +
                "correctly, you will get a shortcut to Monster number 3, where you will also receive a reward. \n" +
                "If you'll answer incorrectly, you will have to challenge Monster number 2 before meeting number 3." +
                "Good luck, here it comes.....\n" +
                "What is always in front of you, but you can't see it?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("future")) {
            System.out.println("Correct answer! Good job! Now you won't have to meet Monster 2 \n" +
                    "and you can go straight to Monster 3!");
            System.out.println();
            Room.MonsterRoom3(player);


        } else {
            System.out.println("Wrong answer, a door appears to the west. You pass through it, as you have no other choice.");
            System.out.println();
            Room.MonsterRoom2(player);
        }
    }

    public static void MonsterRoom2(Player player) {
        Monster monster = new Monster("Wolf", 7, 1);
        System.out.println("As you enter the room, you see a large " + monster.getName() + " sleeping in the corner. \n" +
                "Suddenly it wakes up and looks at you with his red eyes. The " + monster.getName() + " charges towards you \n" +
                "and you go to attack.");
        Room.doBattle(player, monster, monster.getHealthPoints(), player.getHealthPoints(), monster.getDamage(), player.getDamage());
        System.out.println("Good job! You survived! \n" +
                "There's a door to the south, do you wish to pass through?(s)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("s")) {
            Room.MonsterRoom3(player);
        } else {
            System.exit(0);
            System.out.println("Wrong answer, now you'll die. \n Game over!");

        }
    }


    public static void MonsterRoom3(Player player) {
        Monster monster = new Monster("Giant", 10, 1);
        System.out.println("You open the door and see a large room. In the middle of the room you see a very angry looking " + monster.getName() +
                ".\n In the back of the room you can see a door with a large dragon crest. This must be the door to the dragon!" +
                "\n The " + monster.getName() + " yells: \n No one shall enter the dragons lair! Prepare to die!");
        System.out.println("You run towards the " + monster.getName() + " to attack!");
        Room.doBattle(player, monster, monster.getHealthPoints(), player.getHealthPoints(), monster.getDamage(), player.getDamage());
        System.out.println();
        System.out.println("Congratulations, you killed the " + monster.getName() + "!");
        System.out.println("You see a pile of various items collected by the " + monster.getName() +
                ". Select one of the following options: \n1. Search through the pile\n2. Go straight to the dragon door");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            Potion potion = new Potion("healthPotion", "restores health for the user", 10);

            System.out.println("As you search through the various items, you find a " + potion.getName() + ". Do you wish to drink it? \n" +
                    "Yes(1) \n No(2)");
            int drink = scanner.nextInt();

            if (drink == 1) {
                player.setHealthPoints(potion.getHealth());
                System.out.println("You chose to drink the " + potion.getName() + " You feel refreshed and stronger then ever! \n" +
                        "You now have " + player.getHealthPoints() + " health points remaining.");
            }
        }
        System.out.println("You will now enter the last room to face the ferocius dragon.");
        System.out.println();

        Room.DragonRoom(player);
    }

    public static void DragonRoom(Player player) {
        Monster monster = new Monster("Dragon", 12, 2);
        System.out.println("You enter the final room of the dungeon.\n The room is huge, and on a pile of gold, you see the " + monster.getName() + " sleeping. \n ");
        System.out.println(
                "                                                  .~))>>\n" +
                        "                                                 .~)>>\n" +
                        "                                               .~))))>>>\n" +
                        "                                             .~))>>             ___\n" +
                        "                                           .~))>>)))>>      .-~))>>\n" +
                        "                                         .~)))))>>       .-~))>>)>\n" +
                        "                                       .~)))>>))))>>  .-~)>>)>\n" +
                        "                   )                 .~))>>))))>>  .-~)))))>>)>\n" +
                        "                ( )@@*)             //)>))))))  .-~))))>>)>\n" +
                        "              ).@(@@               //))>>))) .-~))>>)))))>>)>\n" +
                        "            (( @.@).              //))))) .-~)>>)))))>>)>\n" +
                        "          ))  )@@*.@@ )          //)>))) //))))))>>))))>>)>\n" +
                        "       ((  ((@@@.@@             |/))))) //)))))>>)))>>)>\n" +
                        "      )) @@*. )@@ )   (\\_(\\-\\b  |))>)) //)))>>)))))))>>)>\n" +
                        "    (( @@@(.@(@ .    _/`-`  ~|b |>))) //)>>)))))))>>)>\n" +
                        "     )* @@@ )@*     (@)  (@) /\\b|))) //))))))>>))))>>\n" +
                        "   (( @. )@( @ .   _/  /    /  \\b)) //))>>)))))>>>_._\n" +
                        "    )@@ (@@*)@@.  (6///6)- / ^  \\b)//))))))>>)))>>   ~~-.\n" +
                        " ( @jgs@@. @@@.*@_ VvvvvV//  ^  \\b/)>>))))>>      _.     `bb\n" +
                        " ((@@ @@@*.(@@ . - | o |' \\ (  ^   \\b)))>>        .'       b`,\n" +
                        "   ((@@).*@@ )@ )   \\^^^/  ((   ^  ~)_        \\  /           b `,\n" +
                        "     (@@. (@@ ).     `-'   (((   ^    `\\ \\ \\ \\ \\|             b  `.\n" +
                        "       (*.@*              / ((((        \\| | |  \\       .       b `.\n" +
                        "                         / / (((((  \\    \\ /  _.-~\\     Y,      b  ;\n" +
                        "                        / / / (((((( \\    \\.-~   _.`\" _.-~`,    b  ;\n" +
                        "                       /   /   `(((((()    )    (((((~      `,  b  ;\n" +
                        "                     _/  _/      `\"\"\"/   /'                  ; b   ;\n" +
                        "                 _.-~_.-~           /  /'                _.'~bb _.'\n" +
                        "               ((((~~              / /'              _.'~bb.--~\n" +
                        "                                  ((((          __.-~bb.-~\n" +
                        "                                              .'  b .~~\n" +
                        "                                              :bb ,' \n" +
                        "                                              ~~~~\n");
        System.out.println();
        System.out.println("If you defeat the " + monster.getName() + " you will be able to claim the treasure! \n With a roar, you go to attack!");
        Room.doBattle(player, monster, monster.getHealthPoints(), player.getHealthPoints(), monster.getDamage(), player.getDamage());
        System.out.println("Congratulations! You killed the dragon and you can now claim your treasure! ");
        System.out.println(
                "                  _.--.\n" +
                        "              _.-'_:-'||\n" +
                        "          _.-'_.-::::'||\n" +
                        "     _.-:'_.-::::::'  ||\n" +
                        "   .'`-.-:::::::'     ||\n" +
                        "  /.'`;|:::::::'      ||_\n" +
                        " ||   ||::::::'      _.;._'-._\n" +
                        " ||   ||:::::'   _.-!oo @.!-._'-.\n" +
                        " \'.  ||:::::.-!() oo @!()@.-'_.||\n" +
                        "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n" +
                        "     `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
                        "      ||-._'-.@.-'_.-' _.-o  |'||\n" +
                        "      ||=[ '-._.-\\U/.-'    o |'||\n" +
                        "      || '-.]=|| |'|      o  |'||\n" +
                        "      ||      || |'|        _| ';\n" +
                        "      ||      || |'|    _.-'_.-'\n" +
                        "      |'-._   || |'|_.-'_.-'\n" +
                        "      '-._'-.|| |' `_.-'\n" +
                        "           '-.||_/.-'\n");
        System.out.println("In the back of the room, you see an exit to the outside world! You take the treasure and go through it");
        System.out.println("End of game, thanks for playing Dragon Treasure!");
        System.out.println("Authors: David & Linn");

    }

    public static void doBattle(Player player, Monster monster, int monsterHealth, int playerHealth, int monsterDamage, int playerDamage) {
        while (monsterHealth > 0) {
            if (playerHealth <= 0) {
                System.out.println("You have died, GAME OVER");
                System.exit(0);
            }
            monsterHealth -= playerDamage;
            System.out.println("You attack the " + monster.getName() + " and do " + playerDamage + " damage");
            if (playerHealth > 0) {

                if (monsterHealth > 0) {
                    playerHealth -= monsterDamage;
                    System.out.println("The " + monster.getName() + " strikes back, you take " + monsterDamage + " damage");
                }

            } else {
                System.out.println("You have died, GAME OVER");
                System.exit(0);
            }
            player.setHealthPoints(playerHealth);
            monster.setHealthPoints(monsterHealth);
            System.out.println();


            if (monsterHealth < 0) {
                monster.setHealthPoints(0);
            }
            if (playerHealth < 0) {
                player.setHealthPoints(0);
            }
            System.out.println("You have " + player.getHealthPoints() + " HealthPoints remaining");
            System.out.println("The " + monster.getName() + " has " + monster.getHealthPoints() + " HealthPoints remaining");
        }

    }
}
