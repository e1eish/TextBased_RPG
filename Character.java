abstract class Character {
    protected int level = 0;
    protected int vigor = 10;
    protected int health = 10;
    protected Weapon weapon;

    public Character(int inputLevel, int inputVigor) {
        level = inputLevel;
        vigor = inputVigor;
        health = vigor;
    }

    public int getLevel() {
        return level;
    }

    public int getVigor() {
        return vigor;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int reduction) {
        health -= reduction;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int heal_amount) {
        health += heal_amount;
        if (health > vigor) {
            health = vigor;
        }
    }

    public void setWeapon(Weapon newWeapon) {
        weapon = newWeapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int attack() {
        int damage = weapon.getPower();
        return damage;
    }
}
