package exercise;

import java.util.Scanner;

public class CommonElements {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String[] firstText = scanner.nextLine().split("\\s+");
    String[] secondText = scanner.nextLine().split("\\s+");

      for (String s : secondText) {
          for (String value : firstText) {
              if (s.equals(value)) {
                  System.out.printf("%s ", s);
              }
          }
      }
  }
}