public class Inventory {
    private int inventorySize = 10;
    private Item[] items = new Item[inventorySize];
    private int gold = 0;

    public Inventory(int size, int wealth) {
        inventorySize = size;
        gold = wealth;
    }

    public void addItem(Item item) {
        if (isFull()) {
            System.out.println("Inventory is full.");
        }
        for (int i = 0; i < inventorySize; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    public Boolean isFull() {
        if (items[inventorySize - 1] != null) {
            return true;
        } else {
            return false;
        }
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void display() {
        System.out.println("\nInventory");
        System.out.println("-----------------");
        
        String goldDisplay = String.format("Gold: %1$s", gold);
        System.out.println(goldDisplay);

        String itemDisplay;
        for (int i = 0; i < inventorySize; i++) {
            if (items[i] != null) {
                itemDisplay = String.format("%1$s: %2$s", items[i].getName(), items[i].getValue());
                System.out.println(itemDisplay);
            }
        }
        System.out.println();
    }
}
