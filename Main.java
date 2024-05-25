import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String scene1Description = "\nYou are standing in a forest and hear a noise behind you. A goblin has jumped out from a bush!\n";
        String scene2Description = "\nYou defeated the goblin and come to a fork in the path. Which way do you go?";
        String scene2LeftDescription = "Left, deeper into the woods.";
        String scene2RightDescription = "Right, where the woods appear to disperse.";
        String deepWoodsDescription = "\nYou find yourself in a dense, dark part of the forest. There is suspicious movement ahead. What will you do?";
        String deepWoodsContinueDescription = "Continue further.";
        String deepWoodsReturnDesription = "Go back and leave the forest.";
        String orcEncounterDescription = "\nAn orc amushes you on the path ahead!\n";
        String leaveForestDescription = "\nYou continue on and find a way out of the forest.\n";
        String fail = "\nYou did not escape the forest.\n";

        Choice[] scene2Choices = new Choice[2];
        Choice left = new Choice(scene2LeftDescription);
        Choice right = new Choice(scene2RightDescription);
        scene2Choices[0] = left;
        scene2Choices[1] = right;
        Scene scene2 = new Scene(scene2Description, scene2Choices);

        Choice[] deepWoodsChoices = new Choice[2];
        Choice continueOn = new Choice(deepWoodsContinueDescription);
        Choice goBack = new Choice(deepWoodsReturnDesription);
        deepWoodsChoices[0] = continueOn;
        deepWoodsChoices[1] = goBack;
        Scene deepwoods = new Scene(deepWoodsDescription, deepWoodsChoices);
        
        System.out.println("\nWhat is your character's name?");
        String playerName = in.nextLine();
        Player player = new Player(playerName);
        Weapon sword = new Weapon("Sword", 10, 10, "strength");
        player.setWeapon(sword);
        Enemy goblin = new Enemy("Goblin", 1, 5, 3);
        Enemy orc = new Enemy("Orc", 1, 10, 3);
        Battle goblinBattle = new Battle(player, goblin, 55, 10);
        Battle orcBattle = new Battle(player, orc, 100, 50);
  
        System.out.println(scene1Description);
        if (!goblinBattle.doBattle(in)) {
            System.out.println(fail);
        } else {
            int scene2Choice = scene2.makeChoice(in);
            if (scene2Choice == 1) {
                int deepWoodsChoice = deepwoods.makeChoice(in);
                if (deepWoodsChoice == 1) {
                    System.out.println(orcEncounterDescription);
                    if (!orcBattle.doBattle(in)) {
                        System.out.println(fail);
                    } else {
                        System.out.println(leaveForestDescription);
                    }
                }
            } else {
                System.out.println(leaveForestDescription);
            }
        }
    }
}
