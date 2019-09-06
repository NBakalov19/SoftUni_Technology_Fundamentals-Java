package exercise;

import java.util.Scanner;

public class AddAndSubtract {

  private static int getResultOfAddAndSubtract(int firstNumber, int secondNumber, int thirdNumber) {

    return getResultOfAdd(firstNumber, secondNumber) - thirdNumber;
  }

  private static int getResultOfAdd(int firstNumber, int secondNumber) {

    return firstNumber + secondNumber;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    int firstNumber = Integer.parseInt(scanner.nextLine());
    int secondNumber = Integer.parseInt(scanner.nextLine());
    int thirdNumber = Integer.parseInt(scanner.nextLine());

    System.out.println(getResultOfAddAndSubtract(firstNumber, secondNumber, thirdNumber));

  }
}
