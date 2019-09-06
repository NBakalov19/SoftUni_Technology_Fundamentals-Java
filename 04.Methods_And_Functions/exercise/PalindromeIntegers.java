package exercise;

import java.util.Scanner;

public class PalindromeIntegers {

  private static boolean isPalindrome(String number) {
    boolean isPalindrome = true;

    int lastInt = number.length() - 1;

    for (int i = 0; i < number.length(); i++) {
      char symbol = number.charAt(i);

      if (symbol != number.charAt(lastInt - i)) {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String numbers = scanner.nextLine();

    while (!numbers.equals("END")) {

      System.out.println(isPalindrome(numbers));

      numbers = scanner.nextLine();
    }
  }
}
