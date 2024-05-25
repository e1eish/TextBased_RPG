import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        /*System.out.println("What is your character's name?");
        String playerName = in.nextLine();
        Player player = new Player(playerName);
        player.displayStats();
        Item item1 = new Item("Sword", 10);
        Item item2 = new Item("Shield", 5);
        player.addItem(item1);
        player.addItem(item2);
        //player.gainExp(55);

        Weapon sword = new Weapon("Sword", 10, 10, "strength");
        player.setWeapon(sword);

        Enemy goblin = new Enemy("Goblin", 1, 10, 2);
        Battle battle = new Battle(player, goblin, 55);
        battle.doBattle(in);
        player.displayStats();
        Enemy orc = new Enemy("Orc", 1, 10, 3);
        Battle orcBattle = new Battle(player, orc, 55);
        orcBattle.doBattle(in);
        player.displayStats();*/

        Choice up = new Choice("Go up.");
        Choice down = new Choice("Go down.");
        Choice[] choices = new Choice[2];
        choices[0] = up;
        choices[1] = down;
        Scene scene = new Scene("This is a scene.", choices);
        System.out.println(scene.makeChoice(in));
    }
}
