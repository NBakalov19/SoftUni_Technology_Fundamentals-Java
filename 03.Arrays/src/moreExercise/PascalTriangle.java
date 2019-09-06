package moreExercise;

import java.util.Scanner;

public class PascalTriangle {
  public static void main(String[] args) {
    int number;
    Scanner scanner = new Scanner(System.in);

    int rows = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < rows; i++) {
      number = 1;
      for (int j = 0; j <= i; j++) {
        System.out.print(number + " ");
        number = number * (i - j) / (j + 1);
      }
      System.out.println();
    }
  }
}