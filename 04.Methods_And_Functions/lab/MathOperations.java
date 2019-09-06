package lab;

import java.util.Scanner;

public class MathOperations {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int firstNumber = Integer.parseInt(scanner.nextLine());
    String operator = scanner.nextLine();
    int secondNumber = Integer.parseInt(scanner.nextLine());

    double result = calculate(firstNumber, operator, secondNumber);

    System.out.println(String.format("%.2f", result));

  }

  private static double calculate(int firstNumber, String operator, int secondNumber) {

    double result = 0d;

    switch (operator) {
      case "/":
        result = firstNumber / (secondNumber * 1.0);
        break;
      case "*":
        result = firstNumber * secondNumber;
        break;
      case "+":
        result = firstNumber + secondNumber;
        break;
      case "-":
        result = firstNumber - secondNumber;
    }
    return result;
  }
}
