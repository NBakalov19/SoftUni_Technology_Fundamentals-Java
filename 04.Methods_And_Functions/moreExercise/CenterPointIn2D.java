package moreExercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CenterPointIn2D {

  private static String getClosestPoints(double x1, double y1, double x2, double y2) {

    double distanceX1Y1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
    double distanceX2Y2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
    if (distanceX1Y1 > distanceX2Y2) {
      return "Second";
    } else {
      return "First";
    }
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    double x1 = Double.parseDouble(scanner.nextLine());
    double y1 = Double.parseDouble(scanner.nextLine());
    double x2 = Double.parseDouble(scanner.nextLine());
    double y2 = Double.parseDouble(scanner.nextLine());

    String closestPoint = getClosestPoints(x1, y1, x2, y2);

    String decX1 = new DecimalFormat("0.####").format(x1);
    String decY1 = new DecimalFormat("0.####").format(y1);
    String decX2 = new DecimalFormat("0.####").format(x2);
    String decY2 = new DecimalFormat("0.####").format(y2);

    if (closestPoint.equals("First")) {
      System.out.printf("(%s, %s)", decX1, decY1);
    } else {
      System.out.printf("(%s, %s)", decX2, decY2);
    }
  }
}