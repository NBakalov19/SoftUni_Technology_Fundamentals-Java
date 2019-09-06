import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> rooms =
                Arrays.stream(scanner.nextLine().split("\\|"))
                        .collect(Collectors.toList());

        int initialHealth = 100;
        int initialCoins = 0;
        int room = 1;
        boolean isCompletedTheQuest = false;

        for (int i = 0; i < rooms.size() ; i++) {
            String[] command = rooms.get(i).split(" ");

            if (command[0].equals("potion")){
                int gainHeal = Integer.parseInt(command[1]);

                if (gainHeal + initialHealth <= 100){
                    initialHealth += gainHeal;
                    System.out.println(String.format("You healed for %d hp.",gainHeal));
                    System.out.println(String.format("Current health: %d hp.",initialHealth));
                } else {
                    gainHeal = 100 - initialHealth;
                    initialHealth += gainHeal;
                    System.out.println(String.format("You healed for %d hp.",gainHeal));
                    System.out.println(String.format("Current health: %d hp.",initialHealth));
                }
            } else if (command[0].equals("chest")){
                int gainCoins = Integer.parseInt(command[1]);
                initialCoins += gainCoins;
                System.out.println(String.format("You found %d coins.",gainCoins));
            } else {
                int monsterAttack = Integer.parseInt(command[1]);
                if (initialHealth - monsterAttack > 0){
                    System.out.println(String.format("You slayed %s.",command[0]));
                    initialHealth -= monsterAttack;
                } else{
                    System.out.println(String.format("You died! Killed by %s.",command[0]));
                    System.out.println(String.format("Best room: %d",room));
                    break;
                }
            }

            if (i == rooms.size() - 1){
                isCompletedTheQuest = true;
            }
            room++;
        }
        if (isCompletedTheQuest){
            System.out.println("You've made it!");
            System.out.println(String.format("Coins: %d",initialCoins));
            System.out.println(String.format("Health: %d",initialHealth));
        }
    }
}