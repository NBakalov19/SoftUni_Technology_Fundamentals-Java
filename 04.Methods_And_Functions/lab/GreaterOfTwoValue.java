package lab;

import java.util.Scanner;

public class GreaterOfTwoValue {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String typeOfValue = scanner.nextLine();

    if ("int".equals(typeOfValue)) {
      int firstInput = Integer.parseInt(scanner.nextLine());
      int secondInput = Integer.parseInt(scanner.nextLine());
      System.out.println(getMax(firstInput, secondInput));

    } else if ("char".equals(typeOfValue)) {
      char firstInput = scanner.nextLine().charAt(0);
      char secondInput = scanner.nextLine().charAt(0);
      System.out.println(getMax(firstInput, secondInput));
    } else if ("String".equals(typeOfValue)) {
      String firstInput = scanner.nextLine();
      String secondInput = scanner.nextLine();
      System.out.println(getMax(firstInput, secondInput));
    }
  }

  private static int getMax(int firstInput, int secondInput) {
    if (firstInput >= secondInput) {
      return firstInput;
    } else {
      return secondInput;
    }
  }

  private static char getMax(char firstInput, char secondInput) {
    if ((int) firstInput > (int) secondInput) {
      return firstInput;
    } else {
      return secondInput;
    }
  }

  private static String getMax(String firstInput, String secondInput) {
    if (firstInput.compareTo(secondInput) >= 0) {
      return firstInput;
    } else {
      return secondInput;
    }
  }
}