package exercise;

import java.util.Scanner;

public class MiddleCharacters {

  private static void printMiddleCharacter(String word) {

    int middleElement = word.length() / 2;

    if (word.length() % 2 == 0) {
      System.out.println("" + word.charAt(middleElement - 1) + word.charAt(middleElement));
    } else {
      System.out.println(word.charAt(middleElement));
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String word = scanner.nextLine();

    printMiddleCharacter(word);
  }
}