package moreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number = Integer.parseInt(scanner.nextLine());

    while (number > 0) {

      String numbersToCompare = scanner.nextLine();

      int leftSum = 0;
      int rightSum = 0;

      int space = numbersToCompare.indexOf(' ');

      String firstNum = numbersToCompare.substring(0, space);
      String secondNum = numbersToCompare.substring(space + 1);


      long leftNumber = Long.parseLong(firstNum);
      long rightNumber = Long.parseLong(secondNum);

      long tempLeftNumber = leftNumber;
      long tempRightNumber = rightNumber;

      while (Math.abs(tempLeftNumber) > 0) {
        leftSum += tempLeftNumber % 10;
        tempLeftNumber /= 10;
      }

      while (Math.abs(tempRightNumber) > 0) {
        rightSum += tempRightNumber % 10;
        tempRightNumber /= 10;
      }

      if (leftNumber > rightNumber) {
        System.out.println(Math.abs(leftSum));
      } else {
        System.out.println(Math.abs(rightSum));
      }
      number--;
    }
  }
}