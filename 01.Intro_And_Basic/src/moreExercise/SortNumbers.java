package moreExercise;

import java.util.Scanner;

public class SortNumbers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int firstNumber = Integer.parseInt(scanner.nextLine());
    int secondNumber = Integer.parseInt(scanner.nextLine());
    int thirdNumber = Integer.parseInt(scanner.nextLine());

    if (firstNumber >= secondNumber && firstNumber > thirdNumber) {
      if (secondNumber >= thirdNumber) {
        System.out.printf("%d\n%d\n%d", firstNumber, secondNumber, thirdNumber);
      } else if (thirdNumber > secondNumber) {
        System.out.printf("%d\n%d\n%d", firstNumber, thirdNumber, secondNumber);
      }
    } else if (secondNumber >= firstNumber && secondNumber > thirdNumber) {
      if (firstNumber >= thirdNumber) {
        System.out.printf("%d\n%d\n%d", secondNumber, firstNumber, thirdNumber);
      } else if (thirdNumber > firstNumber) {
        System.out.printf("%d\n%d\n%d", secondNumber, thirdNumber, firstNumber);
      }
    } else if (thirdNumber >= firstNumber && thirdNumber > secondNumber) {
      if (firstNumber >= secondNumber) {
        System.out.printf("%d\n%d\n%d", thirdNumber, firstNumber, secondNumber);
      } else if (secondNumber > firstNumber) {
        System.out.printf("%d\n%d\n%d", thirdNumber, secondNumber, firstNumber);
      }
    }
  }
}