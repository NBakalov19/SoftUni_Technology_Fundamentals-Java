package lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double number = Double.parseDouble(scanner.nextLine());
    int power = Integer.parseInt(scanner.nextLine());


    System.out.println(new DecimalFormat("0.####")
            .format(raiseToPower(number, power)));
  }

  private static double raiseToPower(double number, int power) {

    double result = 0d;

    result = Math.pow(number, power);

    return result;
  }
}