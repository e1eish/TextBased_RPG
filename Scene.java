import java.util.Scanner;

public class Scene {
    private String description;
    private Choice[] choices;

    public Scene(String newDescription, Choice[] newChoices) {
        description = newDescription;
        choices = newChoices;
    }

    public void display() {
        System.out.println("\n" + description);
        for (int i = 0; i < choices.length; i++) {
            String output = String.format("%1$d: %2$s", i + 1, choices[i].description);
            System.out.println(output);
        }
        //System.out.println("\n");
    }

    public int makeChoice(Scanner scanner) {
        display();
        boolean isValid = false;
        int choice = 0;
        while (!isValid) {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= choices.length) {
                isValid = true;
            } else {
                System.out.println("Please choose an option.");
            }
        }
        return choice;
    }

    public String getDescription() {
        return description;
    }
}
