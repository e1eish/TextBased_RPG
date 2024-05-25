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
}
