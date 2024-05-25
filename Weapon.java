public class Weapon extends Item {
    int attackPower;
    String type;

    public Weapon(int power, String weaponType) {
        attackPower = power;
        type = weaponType.toLowerCase();
    }

    public int getPower() {
        return attackPower;
    }

    public String getType() {
        return type;
    }
}
