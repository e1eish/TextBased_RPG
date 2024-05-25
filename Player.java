public class Player extends Character {
    private String name;
    
    public Player(String inputName) {
        super(0, 10, 10, 10, 1, 1);
        this.name = inputName;
    }

    public void levelUp(String stat) {
        this.level += 1;
        if (stat.toLowerCase() == "strength") {
            this.strength += 1;
        } else {
            this.intelligence += 1;
        }
    }

    public String getName() {
        return name;
    }
}
