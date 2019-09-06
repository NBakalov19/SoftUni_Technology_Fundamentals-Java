package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_BakingRush {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> events =
            Arrays.stream(scanner.nextLine().split("\\|"))
                    .collect(Collectors.toList());


    int initialCoins = 100;
    int initialEnergy = 100;

    boolean isOrdersComplete = false;

    for (int i = 0; i < events.size(); i++) {
      String[] command = events.get(i).split("-");

      if (command[0].equals("rest")) {
        int gainEnergy = Integer.parseInt(command[1]);

        if (gainEnergy + initialEnergy <= 100) {
          initialEnergy += gainEnergy;
          System.out.println(String.format("You gained %d energy.", gainEnergy));
          System.out.println(String.format("Current energy: %d.", initialEnergy));
        } else {
          System.out.println("You gained 0 energy.");
          System.out.println(String.format("Current energy: %d.", initialEnergy));
        }
      } else if (command[0].equals("order")) {
        if (initialEnergy >= 30) {
          int earnedCoins = Integer.parseInt(command[1]);
          System.out.println(String.format("You earned %d coins.", earnedCoins));
          initialCoins += earnedCoins;
          initialEnergy -= 30;
        } else {
          System.out.println("You had to rest!");
          initialEnergy += 50;
        }
      } else {
        String ingredient = command[0];
        int priceForIngredient = Integer.parseInt(command[1]);

        if (initialCoins - priceForIngredient > 0) {
          System.out.println(String.format("You bought %s.", ingredient));
          initialCoins -= priceForIngredient;
        } else {
          System.out.println(String.format("Closed! Cannot afford %s.", ingredient));
          break;
        }
      }
      if (i == events.size() - 1) {
        isOrdersComplete = true;
      }
    }

    if (isOrdersComplete) {
      System.out.println("Day completed!");
      System.out.printf("Coins: %d%n", initialCoins);
      System.out.printf("Energy: %d%n", initialEnergy);
    }
  }
}