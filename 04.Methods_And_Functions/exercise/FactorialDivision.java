package exercise;

import java.util.Scanner;

public class FactorialDivision {

  private static double getFactorial(int number) {
    double factorial = 1d;

    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }
    return factorial;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int firstNumber = Integer.parseInt(scanner.nextLine());
    int secondNumber = Integer.parseInt(scanner.nextLine());

    double result = getFactorial(firstNumber) / getFactorial(secondNumber);

    System.out.printf("%.2f", result);
  }
}