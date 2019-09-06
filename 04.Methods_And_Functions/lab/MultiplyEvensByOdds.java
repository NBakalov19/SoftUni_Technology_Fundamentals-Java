package lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number = Integer.parseInt(scanner.nextLine());

    System.out.println(getMultiplyOfEvensAndOdds(number));
  }

  private static int getMultiplyOfEvensAndOdds(int number) {
    int evenSum = 0;
    int oddSum = 0;
    while (Math.abs(number) > 0) {
      int digit = number % 10;
      if (digit % 2 == 0) {
        evenSum += digit;
      } else {
        oddSum += digit;
      }
      number /= 10;
    }
    return evenSum * oddSum;

  }
}