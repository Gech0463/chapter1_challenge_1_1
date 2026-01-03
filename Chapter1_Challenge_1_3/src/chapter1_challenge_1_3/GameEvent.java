package chapter1_challenge_1_3;

import java.util.Random;
import java.util.Scanner;

public abstract class GameEvent {
    protected Random rand = new Random();
    protected Scanner scanner;

    public GameEvent(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void trigger(Player player);
}
