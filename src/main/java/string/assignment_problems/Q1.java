import java.util.Scanner;

public class Q1 {
    static class Character {
        private int health;
        private final int maxHealth;

        public Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = maxHealth;
        }

        public void takeDamage(int amount) {
            if (amount > 0) {
                this.health -= amount;
                if (this.health < 0) {
                    this.health = 0;
                }
            }
        }

        public void heal(int amount) {
            if (amount > 0) {
                this.health += amount;
                if (this.health > this.maxHealth) {
                    this.health = this.maxHealth;
                }
            }
        }

        public int getHealth() {
            return this.health;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        Character c = new Character(scanner.nextInt());
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            int amt = scanner.nextInt();
            if (op.equals("damage")) c.takeDamage(amt);
            else if (op.equals("heal")) c.heal(amt);
        }
        System.out.println(c.getHealth());
        scanner.close();
    }
}
