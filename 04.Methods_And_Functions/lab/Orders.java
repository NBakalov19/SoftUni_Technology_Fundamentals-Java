package lab;

import java.util.Scanner;

public class Orders {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String product = scanner.nextLine().toLowerCase();
    int quantity = Integer.parseInt(scanner.nextLine());

    switch (product) {
      case "coffee":
        calculateCoffee(quantity);
        break;
      case "water":
        calculateWater(quantity);
        break;
      case "coke":
        calculateCoke(quantity);
        break;
      case "snacks":
        calculateSnacks(quantity);
        break;

    }
  }

  private static void calculateCoffee(int quantity) {
    System.out.printf("%.2f", 1.5 * quantity);
  }

  private static void calculateWater(int quantity) {
    System.out.printf("%.2f", 1.0 * quantity);
  }

  private static void calculateCoke(int quantity) {
    System.out.printf("%.2f", 1.4 * quantity);
  }

  private static void calculateSnacks(int quantity) {
    System.out.printf("%.2f", 2.0 * quantity);
  }
}