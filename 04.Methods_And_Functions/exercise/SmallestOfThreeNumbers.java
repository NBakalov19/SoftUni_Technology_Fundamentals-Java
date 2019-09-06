package exercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int firstNumber = Integer.parseInt(scanner.nextLine());
    int secondNumber = Integer.parseInt(scanner.nextLine());
    int thirdNumber = Integer.parseInt(scanner.nextLine());

    printSmallest(firstNumber, secondNumber, thirdNumber);
  }

  private static void printSmallest(int firstNumber, int secondNumber, int thirdNumber) {
    int minInteger = Integer.MAX_VALUE;

    if (minInteger > firstNumber) {
      minInteger = firstNumber;
      if (firstNumber > secondNumber) {
        minInteger = secondNumber;
        if (secondNumber > thirdNumber) {
          minInteger = thirdNumber;
        }
      }
    }

    System.out.println(minInteger);
  }
}
