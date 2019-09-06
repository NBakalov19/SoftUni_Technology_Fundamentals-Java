package moreExercise;

import java.util.Scanner;

public class MultiplicationSign {

  private static void printSignOfMultiply(int firstNumber, int secondNumber, int thirdNumber) {

    if (firstNumber < 0 || secondNumber < 0 || thirdNumber < 0) {
      if (firstNumber > 0 && secondNumber < 0 && thirdNumber < 0) {
        System.out.println("positive");
      } else if (firstNumber < 0 && secondNumber > 0 && thirdNumber < 0) {
        System.out.println("positive");
      } else if (firstNumber < 0 && secondNumber < 0 && thirdNumber > 0) {
        System.out.println("positive");
      } else {
        System.out.println("negative");
      }
    } else if (firstNumber == 0 || secondNumber == 0 || thirdNumber == 0) {
      System.out.println("zero");
    } else {
      System.out.println("positive");
    }
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int firstNumber = Integer.parseInt(scanner.nextLine());
    int secondNumber = Integer.parseInt(scanner.nextLine());
    int thirdNumber = Integer.parseInt(scanner.nextLine());

    printSignOfMultiply(firstNumber, secondNumber, thirdNumber);
  }
}