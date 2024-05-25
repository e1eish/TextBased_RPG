public class Main {
    public static void main(String[] args) {
        Player player = new Player("Elwin");
        player.displayStats();
        Item item1 = new Item("Sword", 10);
        Item item2 = new Item("Shield", 5);
        player.addItem(item1);
        player.addItem(item2);
        player.displayInventory();
    }
}
