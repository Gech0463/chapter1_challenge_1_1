package chapter1_challenge_1_3;

import java.util.Random;
import java.util.Scanner;

public class Chapter1_Challenge_1_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(100);
        Random rand = new Random();

        System.out.println("Welcome to the Dungeon!");
        System.out.println("Survive 5 rooms to win. Collect gold and stay alive!");

        for (int room = 1; room <= 5; room++) {
            System.out.println("\n-----------------------------------");
            System.out.println("Entering room " + room + "...");
            System.out.println("Current Health: " + player.getHealth() + " | Gold: " + player.getGold());

            GameEvent event;

            if (room == 5) {
                // Boss Battle
                event = new MonsterEvent(scanner, true);
            } else {
                // Random Event
                int eventType = rand.nextInt(4) + 1;
                switch (eventType) {
                    case 1:
                        event = new TrapEvent(scanner);
                        break;
                    case 2:
                        event = new PotionEvent(scanner);
                        break;
                    case 3:
                        event = new MonsterEvent(scanner, false);
                        break;
                    case 4:
                        event = new TreasureEvent(scanner);
                        break;
                    default:
                        event = new TrapEvent(scanner); // Fallback
                        break;
                }
            }

            event.trigger(player);

            if (!player.isAlive()) {
                System.out.println("\n-----------------------------------");
                System.out.println("GAME OVER");
                System.out.println("You have been defeated in room " + room + ".");
                System.out.println("Final Score (Gold): " + player.getGold());
                break;
            }
        }

        if (player.isAlive()) {
            System.out.println("\n-----------------------------------");
            System.out.println("CONGRATULATIONS!");
            System.out.println("You cleared the dungeon! Victorious with " + player.getHealth() + " health!");
            System.out.println("Total Gold Collected: " + player.getGold());
        }

        scanner.close();
    }
}
