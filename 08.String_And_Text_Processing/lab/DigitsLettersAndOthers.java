package lab;

import java.util.Scanner;

public class DigitsLettersAndOthers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String text = scanner.nextLine();
    StringBuilder digits = new StringBuilder();
    StringBuilder letters = new StringBuilder();
    StringBuilder others = new StringBuilder();

    for (char i = 0; i < text.length(); i++) {
      if (Character.isDigit(text.charAt(i))) {
        digits.append(text.charAt(i));
      } else if (Character.isLetter(text.charAt(i))) {
        letters.append(text.charAt(i));
      } else {
        others.append(text.charAt(i));
      }
    }

    System.out.println(digits);
    System.out.println(letters);
    System.out.println(others);
  }
}