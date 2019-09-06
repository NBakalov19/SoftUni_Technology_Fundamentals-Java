package exercise;

import java.util.Scanner;

public class VowelCount {

  private static int getVowelsCount(String text) {

    int counter = 0;

    for (int i = 0; i < text.length(); i++) {
      String textToLowerCase = text.toLowerCase();

      switch (textToLowerCase.charAt(i)) {
        case 'a':
          case 'e':
          case 'i':
          case 'o':
          case 'u':
              counter++;
          break;
      }

    }
    return counter;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String text = scanner.nextLine();

    System.out.println(getVowelsCount(text));

  }
}
