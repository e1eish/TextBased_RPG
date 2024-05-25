public class Weapon extends Item {
    int attackPower;
    String type;

    public Weapon(String inputName, int inputValue, int power, String weaponType) {
        super(inputName, inputValue);
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
