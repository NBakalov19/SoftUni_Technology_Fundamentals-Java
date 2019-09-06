package moreExercise;

import java.util.Scanner;

public class DataTypes {

  private static int getDataType(int number) {
      return 2 * number;
  }

  private static double getDataType(double number) {
      return 1.5 * number;
  }

  private static String getDataType(String text) {
      return "$" + text + "$";
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String type = scanner.nextLine();

    switch (type) {
      case "int":
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(getDataType(number));
        break;
      case "real":
        double realNumber = Double.parseDouble(scanner.nextLine());
        double result = getDataType(realNumber);
        System.out.printf("%.2f", result);
        break;
      case "string":
        String text = scanner.nextLine();
        System.out.println(getDataType(text));
        break;
    }
  }
}