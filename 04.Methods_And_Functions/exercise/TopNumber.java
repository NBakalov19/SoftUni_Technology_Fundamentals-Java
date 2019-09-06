package exercise;

import java.util.Scanner;

public class TopNumber {

  private static boolean isDivisibleByEight(int number) {
    boolean isDivisible = false;
    int sumOfDigits = 0;

    while (number > 0) {
      int digit = number % 10;
      sumOfDigits += digit;
      number /= 10;
    }

    if (sumOfDigits % 8 == 0) {
      isDivisible = true;
    }

    return isDivisible;
  }

  private static boolean isContainOddDigit(int number) {
    boolean isContainOdd = false;

    while (number > 0) {
      int digit = number % 10;
      if (digit % 2 == 1) {
        isContainOdd = true;
        break;
      }
      number /= 10;
    }

    return isContainOdd;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i <= number; i++) {

      if (isContainOddDigit(i) && isDivisibleByEight(i)) {
        System.out.println(i);
      }
    }
  }
}
