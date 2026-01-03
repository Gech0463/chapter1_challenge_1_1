package chapter1_challenge_1_3;

public class Player {
    private int health;
    private int maxHealth;
    private int gold;

    public Player(int startHealth) {
        this.maxHealth = startHealth;
        this.health = startHealth;
        this.gold = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public void heal(int amount) {
        this.health += amount;
        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
