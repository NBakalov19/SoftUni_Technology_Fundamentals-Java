package moreExercise;

import java.util.Scanner;

public class FloatingEquality {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double firstNumber = Double.parseDouble(scanner.nextLine());
    double secondNumber = Double.parseDouble(scanner.nextLine());

    double eps = 0.000001;

    double difference = Math.abs(firstNumber - secondNumber);

    if (eps > difference) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }
}