public class Enemy extends Character {
    private String name;
    private int attackPower;
    
    public Enemy(String inputName, int inputLevel, int inputHealth, int inputPower) {
        super(inputLevel, inputHealth);
        name = inputName;
        attackPower = inputPower;
    }

    public String getName() {
        return name;
    }

    public int attack() {
        int damage = attackPower;
        return damage;
    }
}
