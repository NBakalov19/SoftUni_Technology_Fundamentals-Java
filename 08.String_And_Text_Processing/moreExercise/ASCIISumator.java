package moreExercise;

import java.util.Scanner;

public class ASCIISumator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char first = scanner.nextLine().charAt(0);
    char second = scanner.nextLine().charAt(0);
    String text = scanner.nextLine();

    int sum = 0;

    int minChar = Math.min(first, second);
    int maxChar = Math.max(first, second);

    for (int i = 0; i < text.length(); i++) {
      int currChar = text.charAt(i);

      if (currChar > minChar && currChar < maxChar) {
        sum += currChar;
      }
    }
    System.out.println(sum);
  }
}