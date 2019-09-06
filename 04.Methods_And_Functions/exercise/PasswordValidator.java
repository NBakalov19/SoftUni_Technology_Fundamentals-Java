package exercise;

import java.util.Scanner;

public class PasswordValidator {

  private static boolean validatePassword(String password) {

    boolean correctCharCount = validateCount(password);
    boolean onlyLettersAndDigits = validateContain(password);
    boolean haveTwoDigits = validateDigitsCount(password);

    return correctCharCount && onlyLettersAndDigits && haveTwoDigits;

  }

  private static boolean validateDigitsCount(String password) {
    int digitCount = 0;

    for (int i = 0; i < password.length(); i++) {
      char symbol = password.charAt(i);

      if (Character.isDigit(symbol)) {

        digitCount++;
        if (digitCount >= 2) {
          return true;
        }
      }
    }
    System.out.println("Password must have at least 2 digits");
    return false;
  }

  private static boolean validateContain(String password) {

    for (int i = 0; i < password.length(); i++) {
      char symbol = password.charAt(i);

      if (!Character.isLetterOrDigit(symbol)) {
        System.out.println("Password must consist only of letters and digits");
        return false;
      }
    }

    return true;
  }

  private static boolean validateCount(String password) {
    boolean isValid = password.length() > 5 && password.length() < 11;

    if (!isValid) {
      System.out.println("Password must be between 6 and 10 characters");
      return false;
    }

    return true;

  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String password = scanner.nextLine();

    if (validatePassword(password)) {
      System.out.println("Password is valid");
    }
  }
}