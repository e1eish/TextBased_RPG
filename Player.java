import java.util.Scanner;

public class Player extends Character {
    private String name;
    private int stamina = 10;
    private int mana = 10;
    private int strength = 1;
    private int intelligence = 1;
    private int exp = 0;
    private Inventory inventory = new Inventory(10, 0, 0);
    
    public Player(String inputName) {
        super(0, 10);
        this.name = inputName;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void displayStats() {
        String title = String.format("\n%1$s - Health: %2$s\nExperience: %3$s", name, health, exp);
        System.out.println(title);
        System.out.println("-----------------");
        String outputString = String.format("Level: %1$8s\nVigor: %2$9s\nStamina: %3$7s\nMana: %4$10s\nStrength: %5$5s\nIntelligence: %6$s", level, vigor, stamina, mana, strength, intelligence);
        System.out.println("\n" + outputString + "\n");
    }

    public int attack() {
        int damage;
        if (weapon.getType() == "strength") {
            damage = weapon.getPower() * strength;
        } else {
            damage = weapon.getPower() * intelligence;
        }
        return damage;
    }

    public void levelUp(int stat) {
        this.level += 1;
        exp -= 50;
        this.vigor += 1;
        this.health = this.vigor;
        if (stat == 1) {
            this.strength += 1;
            this.stamina += 1;
        } else {
            this.intelligence += 1;
            this.mana += 1;
        }
    }

    public void gainExp(Scanner scanner, int amount) {
        exp += amount;
        if (exp >= 50) {
            boolean isValid = false;
            int choice = 0;
            while (isValid == false) {
                //try (Scanner scanner = new Scanner(System.in)) {
                try {
                    System.out.println("You have leveled up!\nWhich stat do you want to increase?");
                    System.out.println("1: Strength\n2: Intelligence");

                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 2) {
                        isValid = true;
                    } else {
                        System.out.println("Please choose one of the options.");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter an integer value.");
                }
            }
            levelUp(choice);
        }
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public void displayInventory() {
        inventory.display();
    }

    public int getPotions() {
        return inventory.getPotions();
    }
}
