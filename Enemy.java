public class Enemy extends Character {
    private String name;
    
    public Enemy(String inputName, int inputLevel, int inputHealth, int inputStamina, int inputMana, int inputStrength, int inputIntelligence) {
        super(inputLevel, inputHealth, inputStamina, inputMana, inputStrength, inputIntelligence);
        this.name = inputName;
    }

    public String getName() {
        return name;
    }
}
