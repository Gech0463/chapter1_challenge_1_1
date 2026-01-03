package chapter1_challenge_1_3;

import java.util.Scanner;

public class TreasureEvent extends GameEvent {

    public TreasureEvent(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void trigger(Player player) {
        int goldFound = rand.nextInt(30) + 10;
        player.addGold(goldFound);
        System.out.println("You found a Treasure Chest! It contains " + goldFound + " gold.");
    }
}
