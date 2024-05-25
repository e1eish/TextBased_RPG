import java.util.Scanner;

public class Battle {
    Player player;
    Enemy enemy;
    int experienceGain;
    int goldReward;

    public Battle(Player newPlayer, Enemy newEnemy, int experience, int gold) {
        player = newPlayer;
        enemy = newEnemy;
        experienceGain = experience;
        goldReward = gold;
    }

    private void playerDamagesEnemy() {
        int damage = player.attack();
        enemy.reduceHealth(damage);
        String attackMessage = String.format("%1$s attacks %2$s.", player.getName(), enemy.getName());
        System.out.println(attackMessage);
        String damageMessage = String.format("%1$s dealt %2$d damage to %3$s.\n", player.getName(), damage, enemy.getName());
        System.out.println(damageMessage);
    }

    private void enemyDamagesPlayer() {
        int damage = enemy.attack();
        player.reduceHealth(damage);
        String attackMessage = String.format("%1$s attacks %2$s.", enemy.getName(), player.getName());
        System.out.println(attackMessage);
        String message = String.format("%1$s dealt %2$d damage to %3$s.\n", enemy.getName(), damage, player.getName());
        System.out.println(message);
    }

    private boolean isDead(Character actor) {
        if (actor.getHealth() <= 0) {
            return true;
        }
        return false;
    }

    public int getPlayerAction(Scanner in) {
        boolean isValid = false;
        int action = 0;
        //Scanner in = new Scanner(System.in);
        while (isValid == false) {
            //try (Scanner scanner = new Scanner(System.in)) {
                //Scanner in = new Scanner(System.in);
                System.out.println();
                System.out.println("What will you do?");
                System.out.println("1: Attack an enemy");
                System.out.println("2: Heal");
                System.out.println("3: Run (25%)");
                System.out.println();

                action = in.nextInt();
                
                if (action >= 1 && action <= 3) {
                    isValid = true;
                } else {
                    System.out.println("Please choose one of the options.");
                }
            //} catch (Exception e) {
            //    System.out.println("Please enter an integer value.");
            //}
        }
        return action;
    }

    private boolean runSuccess() {
        int success = (int)(Math.random() * 101);
        if (success > 75) {
            return true;
        }
        return false;
    }

    private void healPlayer() {
        player.heal(10);
    }

    private void displayState() {
        String playerState = String.format("%1$s - Health: %2$d", player.getName(), player.getHealth());
        String enemyState = String.format("%1$s - Health: %2$d", enemy.getName(), enemy.getHealth());
        System.out.println(playerState);
        System.out.println(enemyState);
    }

    public boolean doBattle(Scanner in) {
        boolean isPlayerTurn = true;
        boolean ranAway = false;
        while (isDead(player) == false && isDead(enemy) == false && ranAway == false) {
            displayState();
            if (isPlayerTurn) {    
                int action = getPlayerAction(in);
                if (action == 1) {
                    playerDamagesEnemy();
                } else if (action == 2) {
                    healPlayer();
                } else {
                    if (runSuccess()) {
                        ranAway = true;
                    } else {
                        System.out.println("You couldn't escape!");
                    }
                }
                isPlayerTurn = false;
            } else {
                enemyDamagesPlayer();
                isPlayerTurn = true;
            }
        }
        if (isDead(enemy)) {
            String message = String.format("You defeated %s!", enemy.getName());
            System.out.println(message);
            player.gainExp(in, experienceGain);
            player.gainGold(goldReward);
            player.heal(1000);
            return true;
        } else if (ranAway){
            System.out.println("You ran away.");
            return true;
        } else {
            System.out.println("You were defeated.");
            return false;
        }
    }
}
