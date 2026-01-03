package chapter1_challenge_1_3;

import java.util.Scanner;

public class TrapEvent extends GameEvent {

    public TrapEvent(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void trigger(Player player) {
        int damage = rand.nextInt(15) + 10;
        player.takeDamage(damage);
        System.out.println("A trap sprung! You took " + damage + " damage.");
    }
}
