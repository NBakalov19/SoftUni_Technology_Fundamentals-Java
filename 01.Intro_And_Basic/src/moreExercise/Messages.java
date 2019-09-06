package moreExercise;

import java.util.Scanner;

public class Messages {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfLetters = Integer.parseInt(scanner.nextLine());
    StringBuilder message = new StringBuilder();
    while (countOfLetters > 0) {
      int code = Integer.parseInt(scanner.nextLine());
      int mainDigit = code % 10;
      int numbersOfDigits = 0;
      if (code != 0) {
        while (code > 0) {
          code /= 10;

          numbersOfDigits++;

          int offset = (mainDigit - 2) * 3;
          int indexOfLetter = 0;
          if (mainDigit != 8 || mainDigit != 9) {
            indexOfLetter = (offset + numbersOfDigits - 1);
          } else {
            indexOfLetter = ((offset + 1) + numbersOfDigits - 1);
          }

          message.append((char) (97 + indexOfLetter));
        }
      } else {
        message.append((char) (32));
      }
      countOfLetters--;
    }
    System.out.println(message);
  }
}
