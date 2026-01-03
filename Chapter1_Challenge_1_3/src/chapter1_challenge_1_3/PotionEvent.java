package chapter1_challenge_1_3;

import java.util.Scanner;

public class PotionEvent extends GameEvent {

    public PotionEvent(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void trigger(Player player) {
        int healAmount = rand.nextInt(15) + 10;
        int oldHealth = player.getHealth();
        player.heal(healAmount);
        int healed = player.getHealth() - oldHealth;
        
        if (healed < healAmount) {
             System.out.println("You found a healing potion! Health restored to max (" + player.getHealth() + ").");
        } else {
             System.out.println("You found a healing potion! Restored " + healed + " health.");
        }
    }
}
