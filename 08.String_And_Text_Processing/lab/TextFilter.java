package lab;

import java.util.Scanner;

public class TextFilter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] bannedWords = scanner.nextLine().split(", ");
    String text = scanner.nextLine();

    for (String bannedWord : bannedWords) {

      text = text.replace(bannedWord, replacement(bannedWord.length()));
    }

    System.out.println(text);
  }

  private static String replacement(int count) {
    return "*".repeat(Math.max(0, count));
  }
}