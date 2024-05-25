abstract class Character {
    protected int level = 0;
    protected int health = 10;
    protected int stamina = 10;
    protected int mana = 10;
    protected int strength = 1;
    protected int intelligence = 1;
    protected Weapon weapon;

    public Character(int inputLevel, int inputHealth, int inputStamina, int inputMana, int inputStrength, int inputIntelligence) {
        level = inputLevel;
        health = inputHealth;
        stamina = inputStamina;
        mana = inputMana;
        strength = inputStrength;
        intelligence = inputIntelligence;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int reduction) {
        health -= reduction;
    }

    public void heal(int heal_amount) {
        health += heal_amount;
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

    public void setWeapon(Weapon newWeapon) {
        weapon = newWeapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void displayStats() {
        String outputString = String.format("Level: %1$8s\nHealth: %2$8s\nStamina: %3$7s\nMana: %4$10s\nStrength: %5$5s\nIntelligence: %6$s", level, health, stamina, mana, strength, intelligence);
        System.out.println("\n" + outputString + "\n");
    }

    public int attack(Character target) {
        int damage = 0;
        if (weapon.getType() == "strength") {
            damage = weapon.getPower() * strength;
        } else {
            damage = weapon.getPower() * intelligence;
        }
        return damage;
    }
}
