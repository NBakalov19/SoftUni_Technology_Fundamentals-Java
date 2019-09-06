package moreExercise;

import java.util.Scanner;

public class ExchangeIntegers {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int firstNumber = Integer.parseInt(scanner.nextLine());
    int secondNumber = Integer.parseInt(scanner.nextLine());

    System.out.println(String.format("Before:\na = %d\nb = %d", firstNumber, secondNumber));

    int temp = firstNumber;
    firstNumber = secondNumber;
    secondNumber = temp;

    System.out.println(String.format("After:\na = %d\nb = %d", firstNumber, secondNumber));
  }
}
