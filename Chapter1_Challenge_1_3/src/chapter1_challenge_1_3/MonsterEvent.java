package chapter1_challenge_1_3;

import java.util.Scanner;

public class MonsterEvent extends GameEvent {
    private boolean isBoss;

    public MonsterEvent(Scanner scanner, boolean isBoss) {
        super(scanner);
        this.isBoss = isBoss;
    }

    @Override
    public void trigger(Player player) {
        if (isBoss) {
            System.out.println("WARNING: You have entered the Boss Room!");
            System.out.println("The Dungeon Master appears! Guess a number (1-10) to defeat him!");
        } else {
            System.out.println("A wild monster appears! Guess a number (1-5) to defeat it:");
        }

        int maxRange = isBoss ? 10 : 5;
        int targetNumber = rand.nextInt(maxRange) + 1;
        boolean defeated = false;

        while (!defeated && player.isAlive()) {
            System.out.print("Enter your guess (1-" + maxRange + "): ");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                if (guess == targetNumber) {
                    if (isBoss) {
                        System.out.println("CRITICAL HIT! You defeated the Dungeon Master!");
                        player.addGold(100);
                    } else {
                        System.out.println("You defeated the monster!");
                        int loot = rand.nextInt(20) + 10;
                        player.addGold(loot);
                        System.out.println("You found " + loot + " gold!");
                    }
                    defeated = true;
                } else {
                    int damage = isBoss ? (rand.nextInt(10) + 5) : (rand.nextInt(5) + 1);
                    player.takeDamage(damage);
                    
                    String enemyName = isBoss ? "The Boss" : "The monster";
                    System.out.println("Wrong! " + enemyName + " hits you for " + damage + " damage.");
                    System.out.println("Current Health: " + player.getHealth());

                    if (isBoss) {
                        if (guess < targetNumber) {
                            System.out.println("Hint: The number is higher.");
                        } else {
                            System.out.println("Hint: The number is lower.");
                        }
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear buffer
            }
        }
    }
}
