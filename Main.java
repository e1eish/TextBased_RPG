public class Main {
    public static void main(String[] args) {
        Player player = new Player("Elwin");
        player.displayStats();
        Item item1 = new Item("Sword", 10);
        Item item2 = new Item("Shield", 5);
        player.addItem(item1);
        player.addItem(item2);

        Weapon sword = new Weapon("Sword", 10, 4, "strength");
        player.setWeapon(sword);

        Enemy goblin = new Enemy("Goblin", 1, 10, 2);
        Battle battle = new Battle(player, goblin, 55);
        battle.doBattle();
        player.displayStats();
    }
}
