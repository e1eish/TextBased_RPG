public class Item {
    protected String name = "Default";
    protected int value = 0;

    public Item(String inputName, int inputValue) {
        name = inputName;
        value = inputValue;
    }

    public Item() {
        this("Default", 0);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
