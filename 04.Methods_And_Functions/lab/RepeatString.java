package lab;

import java.util.Scanner;

public class RepeatString {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String word = scanner.nextLine();
    int countToRepeat = Integer.parseInt(scanner.nextLine());

    System.out.println(repeatString(word, countToRepeat));
  }

  private static String repeatString(String word, int countToRepeat) {

      return String.valueOf(word).repeat(Math.max(0, countToRepeat));
  }
}