package lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculateRectangleArea {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double width = Double.parseDouble(scanner.nextLine());
    double height = Double.parseDouble(scanner.nextLine());

    double area = getRectangleArea(width, height);

    String decimalArea = new DecimalFormat("0.####").format(area);
    System.out.println(decimalArea);
  }

  private static double getRectangleArea(double width, double height) {

    return width * height;
  }
}